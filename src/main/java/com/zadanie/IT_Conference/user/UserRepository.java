package com.zadanie.IT_Conference.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //szukanie użytkownika o podanym email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    //szukanie użytkownika o podanym login
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    Optional<User> findUserByLogin(String login);

}
