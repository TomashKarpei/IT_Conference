package com.zadanie.IT_Conference;

import com.zadanie.IT_Conference.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class ItConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItConferenceApplication.class, args);
	}


}
