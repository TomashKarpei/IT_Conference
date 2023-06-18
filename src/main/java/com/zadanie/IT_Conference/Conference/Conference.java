package com.zadanie.IT_Conference.Conference;

import com.zadanie.IT_Conference.prelections.Prelections;
import com.zadanie.IT_Conference.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "CONFERENCE")
public class Conference {
    @Id
    @SequenceGenerator(
            name = "conference_sequence",
            sequenceName = "conference_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "conference_sequence"
    )
    @Column(name = "conf_id", unique = true, nullable = false)
    private long confId;
    @Column(name = "conf_name")
    private String confName;
    @Column(name = "number_of_prelections")
    private int numberOfPrelec;
    @Column(name = "conf_date")
    private LocalDate conferenceDate;
    @Column(name = "conf_start_time")
    private LocalTime conferenceStartTime;
    @Column(name = "conf_end_time")
    private LocalTime conferenceEndTime;
    @Column(name = "lect_duration")
    private Duration lectureDuration;
    @Column(name = "break_duration")
    private Duration breakDuration;

    public Conference(){

    }
    public Conference(long confId,
                      String confName,
                      int numberOfPrelec,
                      LocalDate conferenceDate,
                      LocalTime conferenceStartTime,
                      LocalTime conferenceEndTime,
                      Duration lectureDuration,
                      Duration breakDuration) {
        this.confId = confId;
        this.confName = confName;
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

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
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
                ",confName=" + confName +
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
