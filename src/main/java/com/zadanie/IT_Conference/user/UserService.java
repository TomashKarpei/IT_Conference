package com.zadanie.IT_Conference.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Account with this mail is already created.");
        }
        userRepository.save(user);
    }


    public void deleteUser(Long userId) {
        userRepository.findById(userId);
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id " + userId + " doesn't exists.");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUsersEmail(Long userId, String email) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalStateException("User with id " + userId + " doesn't exists.")
        );
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("Email is already taken.");
            }
            user.setEmail(email);
        }
    }
}
