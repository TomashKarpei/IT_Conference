package com.zadanie.IT_Conference.prelections;

import com.zadanie.IT_Conference.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrelectionsRepository extends JpaRepository<Prelections, Long> {
    @Query("SELECT p FROM Prelections p WHERE (p.firstTopic = ?1 or p.secondTopic = ?1 or p.thirdTopic = ?1) and p.prelecId =?2")
    Optional<Prelections> findTopicByTopic(String topic, long prelecId);
    
}
