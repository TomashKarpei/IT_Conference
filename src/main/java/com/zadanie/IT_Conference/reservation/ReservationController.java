package com.zadanie.IT_Conference.reservation;

import com.zadanie.IT_Conference.user.User;
import com.zadanie.IT_Conference.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/conference/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //wyswietla wszystkie rezerwacji
    //GET localhost:8080/conference/reservation
    @GetMapping()
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    //wyswietla rezerwacje o podanym Id
    //GET localhost:8080/conference/reservation/1
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable long id) {
        return reservationService.getReservationById(id);
    }
    //wyswietla rezerwacje o podanym Loginie uzytkownika
    //GET localhost:8080/conference/reservation/usersReservations/FunTomAsh
    @GetMapping("/usersReservations/{userLogin}")
    public List<Reservation> getReservationById(@PathVariable String userLogin) {
        return reservationService.getReservationByUserLogin(userLogin);
    }

    //Rezerwacja
//    POST localhost:8080/conference/reservation
//    {
//            "userId": 1,
//            "userLogin": "FunTomAsh",
//            "userEmail": "tomash342@gmail.com",
//            "prelecId" : 1,
//            "prelecTopic": "Computer graphics"
//    }
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) throws IOException {
        return reservationService.createReservation(reservation);
    }

    // Usunięcie rezerwacji
                                                   //{id_rezerwacji}
    // DELETE localhost:8080/conference/reservation/1
    @DeleteMapping(path = "{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    // Usunięcie rezerwacji przy podaniu logina uzytkownika oraz id prelekcji
                                                                    //{login_uzytkownika}?prelecId={id_prelekcji}
    // DELETE localhost:8080/conference/reservation/usersReservations/FunTomAsh?prelecId=1
    @DeleteMapping(path = "/usersReservations/{userLogin}")
    public void deleteUserReservation(@PathVariable("userLogin") String userLogin,
                                      @RequestParam(required = true) long prelecId){
        reservationService.deleteReservationByLogin(userLogin, prelecId);
    }





}
