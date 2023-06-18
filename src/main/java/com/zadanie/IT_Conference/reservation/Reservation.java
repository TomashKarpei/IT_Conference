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
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "prelec_id", referencedColumnName = "prelec_id")
    private Prelections prelecId;
    @Column(name = "topic", nullable = false)
    private String prelecTopic;

    public Reservation(long reservationId, User userId, Prelections prelecId, String prelecTopic) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.prelecId = prelecId;
        this.prelecTopic = prelecTopic;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Prelections getPrelecId() {
        return prelecId;
    }

    public void setPrelecId(Prelections prelecId) {
        this.prelecId = prelecId;
    }

    public String getPrelecTopic() {
        return prelecTopic;
    }

    public void setPrelecTopic(String prelecTopic) {
        this.prelecTopic = prelecTopic;
    }
}
