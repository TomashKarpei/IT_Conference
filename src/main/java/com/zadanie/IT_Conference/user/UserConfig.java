package com.zadanie.IT_Conference.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository urep){
        return args ->{
            User tomasz = new User(
                    1L,
                    "Tomasz",
                    "Karpiej",
                    "FunTomAsh",
                    "1234",
                    "tomash342@gmail.com",
                    LocalDate.of(2001, Month.AUGUST, 29)
            );
            User patryk = new User(
                    2L,
                    "Patryk",
                    "Kalinowki",
                    "patryk98",
                    "1234",
                    "patrykK@gmail.com",
                    LocalDate.of(1998, Month.SEPTEMBER, 15)
            );
            User artur = new User(
                    3L,
                    "Artur",
                    "Bucki",
                    "artur99",
                    "1234",
                    "arturB@gmail.com",
                    LocalDate.of(1999, Month.APRIL, 3)
            );
            User kamil = new User(
                    4L,
                    "Kamil",
                    "Andronik",
                    "android99",
                    "1234",
                    "kamilA@gmail.com",
                    LocalDate.of(1999, Month.MAY, 18)
            );
            User mateusz = new User(
                    5L,
                    "Mateusz",
                    "Janiszewski",
                    "mateusz98",
                    "1234",
                    "mateuszJ@gmail.com",
                    LocalDate.of(1998, Month.DECEMBER, 20)
            );
            User jaroslaw = new User(
                    6L,
                    "Jaroslaw",
                    "Bondaruk",
                    "jarek99",
                    "1234",
                    "jarekB@gmail.com",
                    LocalDate.of(1999, Month.JUNE, 5)
            );
            urep.saveAll(List.of(
                tomasz, patryk, artur, kamil, mateusz, jaroslaw
            ));
        };
    }
}
