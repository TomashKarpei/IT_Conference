package com.zadanie.IT_Conference.prelections;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PRELECTIONS")
public class Prelections {
    @Id
    @SequenceGenerator(
            name = "prelection_sequence",
            sequenceName = "prelection_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prelection_sequence"
    )
    @Column(name = "prelec_id", nullable = false)
    private long prelecId;
    @Column(name = "prelection_name", nullable = false)
    private String prelection;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime prelectionStart;
    @Column(name = "end_time", nullable = false)
    private LocalDateTime prelectionEnd;

    @Column(name = "first_topic", nullable = false)
    private String firstTopic;

    @Column(name = "second_topic", nullable = false)
    private String secondTopic;

    @Column(name = "third_topic", nullable = false)
    private String thirdTopic;

    //@OneToMany(mappedBy = "user")
    //@Column(name = "users_id")
    //private List<User> users;

    public Prelections(){

    }

    public Prelections(long prelecId,
                       String prelection,
                       LocalDateTime prelectionStart,
                       LocalDateTime prelectionEnd,
                       String firstTopic,
                       String secondTopic,
                       String thirdTopic) {
        this.prelecId = prelecId;
        this.prelection = prelection;
        this.prelectionStart = prelectionStart;
        this.prelectionEnd = prelectionEnd;
        this.firstTopic = firstTopic;
        this.secondTopic = secondTopic;
        this.thirdTopic = thirdTopic;
    }

    public long getPrelecId() {
        return prelecId;
    }

    public void setPrelecId(long prelecId) {
        this.prelecId = prelecId;
    }

    public String getPrelection() {
        return prelection;
    }

    public void setPrelection(String prelection) {
        this.prelection = prelection;
    }

    public LocalDateTime getPrelectionStart() {
        return prelectionStart;
    }

    public void setPrelectionStart(LocalDateTime prelectionStart) {
        this.prelectionStart = prelectionStart;
    }

    public LocalDateTime getPrelectionEnd() {
        return prelectionEnd;
    }

    public void setPrelectionEnd(LocalDateTime prelectionEnd) {
        this.prelectionEnd = prelectionEnd;
    }

    public String getFirstTopic() {
        return firstTopic;
    }

    public void setFirstTopic(String firstTopic) {
        this.firstTopic = firstTopic;
    }

    public String getSecondTopic() {
        return secondTopic;
    }

    public void setSecondTopic(String secondTopic) {
        this.secondTopic = secondTopic;
    }

    public String getThirdTopic() {
        return thirdTopic;
    }

    public void setThirdTopic(String thirdTopic) {
        this.thirdTopic = thirdTopic;
    }

    @Override
    public String toString() {
        return "Prelections{" +
                "prelecId=" + prelecId +
                ", prelection='" + prelection + '\'' +
                ", prelectionStart=" + prelectionStart +
                ", prelectionEnd=" + prelectionEnd +
                ", firstTopic='" + firstTopic + '\'' +
                ", secondTopic='" + secondTopic + '\'' +
                ", thirdTopic='" + thirdTopic +
                '}';
    }
}
