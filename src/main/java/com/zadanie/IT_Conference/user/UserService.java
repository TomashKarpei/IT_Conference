package com.zadanie.IT_Conference.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class UserService {
    public List<User> getUsers(){
        return List.of(
                new User(
                        1L,
                        "Tomasz",
                        "Karpiej",
                        "FunTomAsh",
                        "1234",
                        "tomash342@gmail.com",
                        LocalDate.of(2001, Month.AUGUST, 29)
                )
        );
    }
}
