package com.zadanie.IT_Conference.Conference;

import com.zadanie.IT_Conference.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class ConferenceConfig {

    @Bean
    CommandLineRunner commandLineRunnerConference (ConferenceRepository crep) {
        return args -> {Conference itConf = new Conference(
                    1L,
                    "It conference",
                    3,
                    LocalDate.of(2023, Month.JUNE, 1),
                    LocalTime.of(10, 0),
                    LocalTime.of(15, 45),
                    Duration.ofMinutes(105),
                    Duration.ofMinutes(15)
            );
            crep.saveAll(List.of(itConf));
        };
    }
}
