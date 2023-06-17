package com.zadanie.IT_Conference.reservation;


import java.time.LocalTime;
public class Reservation {
    private long userId;
    private long prelecId;
    private long prelecPresentId;

    public Reservation(long userId, long prelecId, long prelecPresentId) {
        this.userId = userId;
        this.prelecId = prelecId;
        this.prelecPresentId = prelecPresentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPrelecId() {
        return prelecId;
    }

    public void setPrelecId(long prelecId) {
        this.prelecId = prelecId;
    }

    public long getPrelecPresentId() {
        return prelecPresentId;
    }

    public void setPrelecPresentId(long prelecPresentId) {
        this.prelecPresentId = prelecPresentId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userId=" + userId +
                ", prelecId=" + prelecId +
                ", prelecPresentId=" + prelecPresentId +
                '}';
    }
}
