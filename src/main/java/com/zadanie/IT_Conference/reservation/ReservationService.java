package com.zadanie.IT_Conference.reservation;

import com.zadanie.IT_Conference.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class ReservationService {
    public List<Reservation> getReservations(){
        return List.of(
                new Reservation(1,
                        1,
                        1
                )
        );
    }
}
