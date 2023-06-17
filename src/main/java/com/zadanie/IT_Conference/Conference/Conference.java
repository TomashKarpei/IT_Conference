package com.zadanie.IT_Conference.Conference;

import com.zadanie.IT_Conference.prelections.Prelections;
import com.zadanie.IT_Conference.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Duration;
import java.util.List;

public class Conference {
    private long confId;
    private long prelecId;
    private List<User> users;
    private List<Prelections> prelec;
    private LocalDate conferenceDate;
    private LocalTime conferenceStartTime;
    private LocalTime conferenceEndTime;
    private Duration lectureDuration;
    private Duration breakDuration;
    private int maxListeners;

    public Conference(long confId,
                      long prelecId,
                      List<User> users) {
        this.confId = confId;
        this.prelecId = prelecId;
        this.users = users;
        this.conferenceDate = LocalDate.of(2023, Month.JUNE, 1);
        this.conferenceStartTime = LocalTime.of(10, 0);
        this.conferenceEndTime = LocalTime.of(15, 45);
        this.lectureDuration = Duration.ofMinutes(105);
        this.breakDuration = Duration.ofMinutes(15);
        this.maxListeners = 5;
    }

//    public Conference() {
//        this.conferenceDate = LocalDate.of(2023, Month.JUNE, 1);
//        this.conferenceStartTime = LocalTime.of(10, 0);
//        this.conferenceEndTime = LocalTime.of(15, 45);
//        this.lectureDuration = Duration.ofMinutes(105);
//        this.breakDuration = Duration.ofMinutes(15);
//        this.maxListeners = 5;
//    }

//    private LocalDateTime conf_b;
//    private LocalDateTime conf_e;
//    LocalDateTime.of(2023, Month.JUNE, 1, 10, 00, 00)

}
