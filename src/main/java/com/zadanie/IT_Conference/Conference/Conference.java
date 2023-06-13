package com.zadanie.IT_Conference.Conference;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Duration;

public class Conference {
    private int room;
    private int userID;
    private LocalDate conferenceDate;
    private LocalTime conferenceStartTime;
    private LocalTime conferenceEndTime;
    private Duration lectureDuration;
    private Duration BreakDuration;
    private int maxListeners;

    public Conference() {
        this.conferenceDate = LocalDate.of(2023, Month.JUNE, 1);
        this.conferenceStartTime = LocalTime.of(10, 0);
        this.conferenceEndTime = LocalTime.of(15, 45);
        this.lectureDuration = Duration.ofMinutes(105);
        this.BreakDuration = Duration.ofMinutes(15);
        this.maxListeners = 5;
    }

//    private LocalDateTime conf_b;
//    private LocalDateTime conf_e;
//    LocalDateTime.of(2023, Month.JUNE, 1, 10, 00, 00)

}
