package com.zadanie.IT_Conference.Conference;

import com.zadanie.IT_Conference.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@Configuration
public class ConferenceConfig {

    @Bean
    CommandLineRunner commandLineRunnerConference (ConferenceRepository crep) {
        return args -> {Conference itConf = new Conference(
                    1L,
                    3,
                    LocalDate.of(2023, Month.JUNE, 1),
                    LocalTime.of(10, 0),
                    LocalTime.of(15, 45),
                    Duration.ofMinutes(105),
                    Duration.ofMinutes(15)
            );
        };
    }
}
