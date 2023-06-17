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
    private int numberOfPrelec;
    private LocalDate conferenceDate;
    private LocalTime conferenceStartTime;
    private LocalTime conferenceEndTime;
    private Duration lectureDuration;
    private Duration breakDuration;

    public Conference(long confId,
                      int numberOfPrelec,
                      LocalDate conferenceDate,
                      LocalTime conferenceStartTime,
                      LocalTime conferenceEndTime,
                      Duration lectureDuration,
                      Duration breakDuration) {
        this.confId = confId;
        this.numberOfPrelec = numberOfPrelec;
        this.conferenceDate = conferenceDate;
        this.conferenceStartTime = conferenceStartTime;
        this.conferenceEndTime = conferenceEndTime;
        this.lectureDuration = lectureDuration;
        this.breakDuration = breakDuration;
    }

    public long getConfId() {
        return confId;
    }

    public void setConfId(long confId) {
        this.confId = confId;
    }

    public int getNumberOfPrelec() {
        return numberOfPrelec;
    }

    public void setNumberOfPrelec(int numberOfPrelec) {
        this.numberOfPrelec = numberOfPrelec;
    }

    public LocalDate getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(LocalDate conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public LocalTime getConferenceStartTime() {
        return conferenceStartTime;
    }

    public void setConferenceStartTime(LocalTime conferenceStartTime) {
        this.conferenceStartTime = conferenceStartTime;
    }

    public LocalTime getConferenceEndTime() {
        return conferenceEndTime;
    }

    public void setConferenceEndTime(LocalTime conferenceEndTime) {
        this.conferenceEndTime = conferenceEndTime;
    }

    public Duration getLectureDuration() {
        return lectureDuration;
    }

    public void setLectureDuration(Duration lectureDuration) {
        this.lectureDuration = lectureDuration;
    }

    public Duration getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(Duration breakDuration) {
        this.breakDuration = breakDuration;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "confId=" + confId +
                ", numberOfPrelec=" + numberOfPrelec +
                ", conferenceDate=" + conferenceDate +
                ", conferenceStartTime=" + conferenceStartTime +
                ", conferenceEndTime=" + conferenceEndTime +
                ", lectureDuration=" + lectureDuration +
                ", breakDuration=" + breakDuration +
                '}';
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
