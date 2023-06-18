package com.zadanie.IT_Conference.reservation;

import com.zadanie.IT_Conference.user.User;
import com.zadanie.IT_Conference.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/conference/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping()
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable long id) {
        return reservationService.getReservationById(id);
    }

    //Rezerwacja
//    POST localhost:8080/conference/reservation
//    {
//        "userId": 1,
//            "userLogin": "FunTomAsh",
//            "userEmail": "tomash342@gmail.com",
//            "prelecId" : 1,
//            "prelecTopic": "Computer graphics"
//    }
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    // Usunięcie rezerwacji
                                                   //{id_rezerwacji}
    // DELETE localhost:8080/conference/reservation/1
    @DeleteMapping(path = "{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }




}
