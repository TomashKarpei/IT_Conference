package com.zadanie.IT_Conference.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.prelecId = ?1 and r.userId = ?2")
    Optional<Reservation> findReservationByUserIdAndPrelecId(long prelecId, long userId);

    @Query("SELECT r FROM Reservation r WHERE r.userId = ?1")
    Optional<Reservation> findReservationByUserId(long userId);

    @Query("SELECT r FROM Reservation r WHERE r.userLogin = ?1 and r.prelecId =?2")
    Optional<Reservation> findReservationByUserLoginAndPrelecId(String userLogin, long prelecId);

    @Query("SELECT r FROM Reservation r WHERE r.userLogin = ?1")
    List<Reservation> findReservationByUserLogin(String userLogin);


    @Query("SELECT r FROM Reservation r WHERE r.userEmail = ?1 and r.prelecId =?2")
    Optional<Reservation> findReservationByUserEmail(String userEmail, long prelecId);

    @Query("SELECT count(r) FROM Reservation r WHERE r.prelecId = ?1")
    Long countReservation(long prelecId);
    @Modifying
    @Query("UPDATE Reservation r SET r.userEmail=?2 WHERE r.userId = ?1")
    void updateEmails(long userId, String userEmailNew);

}
