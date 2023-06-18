package com.zadanie.IT_Conference.prelections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrelectionsRepository extends JpaRepository<Prelections, Long> {
    
}
