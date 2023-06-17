package com.zadanie.IT_Conference.prelections;

import com.zadanie.IT_Conference.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrelectionsRepository extends JpaRepository<User, Long> {
    
}
