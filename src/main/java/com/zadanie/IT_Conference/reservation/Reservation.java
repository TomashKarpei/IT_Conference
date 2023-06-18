package com.zadanie.IT_Conference.reservation;


import com.zadanie.IT_Conference.prelections.Prelections;
import com.zadanie.IT_Conference.user.User;
import jakarta.persistence.*;

import java.time.LocalTime;
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    @Column(name = "id", unique = true, nullable = false)
    private long reservationId;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_login", nullable = false)
    private String userLogin;
    @Column(name = "user_email", nullable = false)
    private String userEmail;
    @Column(name = "prelec_id", nullable = false)
    private Long prelecId;
    @Column(name = "topic", nullable = false)
    private String prelecTopic;

    public Reservation(){

    }
    public Reservation(long reservationId, Long userId, String userLogin, String userEmail, Long prelecId, String prelecTopic) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.prelecId = prelecId;
        this.prelecTopic = prelecTopic;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getPrelecId() {
        return prelecId;
    }

    public void setPrelecId(Long prelecId) {
        this.prelecId = prelecId;
    }

    public String getPrelecTopic() {
        return prelecTopic;
    }

    public void setPrelecTopic(String prelecTopic) {
        this.prelecTopic = prelecTopic;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", prelecId=" + prelecId +
                ", prelecTopic='" + prelecTopic + '\'' +
                '}';
    }
}
