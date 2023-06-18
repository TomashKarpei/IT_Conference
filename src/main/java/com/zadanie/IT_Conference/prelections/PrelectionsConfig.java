package com.zadanie.IT_Conference.prelections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class PrelectionsConfig {
    @Bean
    CommandLineRunner commandLineRunnerPrelections(PrelectionsRepository prep){
        return args ->{
            Prelections prelection1 = new Prelections(
                    1L,
                    "Prelection number 1",
                    LocalDateTime.of(2023, Month.JUNE, 1, 10, 00, 00),
                    LocalDateTime.of(2023, Month.JUNE, 1, 11, 45, 00),
                    "Computer graphic",
                    "Internet technologies",
                    "Artificial intelligence"
            );
            Prelections prelection2 = new Prelections(
                    2L,
                    "Prelection number 2",
                    LocalDateTime.of(2023, Month.JUNE, 1, 12, 00, 00),
                    LocalDateTime.of(2023, Month.JUNE, 1, 13, 45, 00),
                    "RayTracing",
                    "Spring Boot",
                    "CNN"
            );
            Prelections prelection3 = new Prelections(
                    3L,
                    "Prelection number 3",
                    LocalDateTime.of(2023, Month.JUNE, 1, 14, 00, 00),
                    LocalDateTime.of(2023, Month.JUNE, 1, 15, 45, 00),
                    "Computer graphic",
                    "Internet technologies",
                    "Artificial intelligence"
            );
            prep.saveAll(List.of(prelection1, prelection2, prelection3));
        };
    }
}
