package com.zadanie.IT_Conference.Conference;

import com.zadanie.IT_Conference.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<User, Long> {

}
