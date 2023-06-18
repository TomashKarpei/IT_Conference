package com.zadanie.IT_Conference.reservation;

import com.zadanie.IT_Conference.prelections.Prelections;
import com.zadanie.IT_Conference.prelections.PrelectionsRepository;
import com.zadanie.IT_Conference.user.User;
import com.zadanie.IT_Conference.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PrelectionsRepository prelectionsRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, PrelectionsRepository prelectionsRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.prelectionsRepository = prelectionsRepository;
        this.userRepository = userRepository;
    }

    //wyswietlenie wszystkich rezerwacji
    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    //tworzenie rezerwacji
    public Reservation createReservation(Reservation reservation) throws IOException {
        Optional<User> findUser =
                userRepository.findUserByLoginEmail(reservation.getUserId(), reservation.getUserLogin(), reservation.getUserEmail());
        //sprawdza, czy uzytkownik jest zarejestrowany
        if (findUser.isEmpty()){
            throw new IllegalStateException("There is no such a user in the system.");
        }

        Optional<Reservation> reservationOptionalUserIdAndPrelecId =
                reservationRepository.findReservationByUserIdAndPrelecId(reservation.getUserId(), reservation.getPrelecId());
        //sprawdza, czy uzytkownik juz ma zarezerwowane miejsce w tej prelekcji
        if (reservationOptionalUserIdAndPrelecId.isPresent()){
            throw new IllegalStateException("You already have a reserved place in this prelection.");
        }

        Optional<Reservation> reservationOptionalEmail =
                reservationRepository.findReservationByUserEmail(reservation.getUserEmail(), reservation.getPrelecId());
        //sprawdza, czy podany przez uzytkonwika mail nie jest zajety
        if (reservationOptionalEmail.isPresent()){
            throw new IllegalStateException("Reservation with this mail is already created.");
        }

        //sprawdza, czy podany przez uzytkonwika login nie jest zajety
        Optional<Reservation> userOptionalLogin =
                reservationRepository.findReservationByUserLoginAndPrelecId(reservation.getUserLogin(), reservation.getPrelecId());
        if (userOptionalLogin.isPresent()){
            throw new IllegalStateException("Reservation with this login is already created.");
        }

        //sprawdza czy podana sciezka istnieje
        Optional<Prelections> prelectionsOptionalTopic =
                prelectionsRepository.findTopicByTopic(reservation.getPrelecTopic(), reservation.getPrelecId());
        if (prelectionsOptionalTopic.isEmpty()){
            throw new IllegalStateException("There is no such a topic.");
        }

        //sprawdza ile miejsc zarezerwowane w prelekcji, jezeli >5 to nie mozna zarezerwować miejsce
        Long reservationOptionalCount = reservationRepository.countReservation(reservation.getPrelecId());
        if (reservationOptionalCount >= 5){
            throw new IllegalStateException("There is no more place for reservations.");
        }

        //Wysylanie wiadomosci przez mail (zapisywwanie do pliku)
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        generateMailNotif("Reservation successful. Notification on email " + reservation.getUserEmail() + " has been sent. Date and Time: "+ formattedDateTime);
        System.out.println("Reservation successful. Notification on email " + reservation.getUserEmail() + " has been sent. Date and Time: "+ formattedDateTime);
        return reservationRepository.save(reservation);
    }

    //Tworzenie pliku z powiadomieniem o wysylaniu potwierdzenia
    public void generateMailNotif(String content) throws IOException {
        String filePath = "/mailNotif.txt";

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
            //System.out.println("Success");
        }
    }

    public Reservation getReservationById(long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.findById(reservationId);

        //spradza, czy rezerwacja istnieje. Jezeli nie - wypisuje komunikat
        boolean exists = reservationRepository.existsById(reservationId);
        if (!exists){
            throw new IllegalStateException("Reservation with id " + reservationId + " doesn't exists.");
        }
        reservationRepository.deleteById(reservationId);
    }


    public List<Reservation> getReservationByUserLogin(String userLogin) {
        return reservationRepository.findReservationByUserLogin(userLogin);
    }

    //usuwanie rezerwacji przez login + id prelekcji
    @Transactional
    public void deleteReservationByLogin(String userLogin, long prelecId) {
        reservationRepository.deleteByUserLogin(userLogin, prelecId);
    }
}