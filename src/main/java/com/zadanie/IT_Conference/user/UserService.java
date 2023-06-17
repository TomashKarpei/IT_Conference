package com.zadanie.IT_Conference.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //wypisuje liste zarejestrowanych uzytkownikow ze wszystkimi danymi
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //dodawanie nowego uzytkownika od bazy danych
    public void addNewUser(User user) {
        Optional<User> userOptionalEmail = userRepository.findUserByEmail(user.getEmail());
        //sprawdza, czy podany przez uzytkonwika mail nie jest zajety
        if (userOptionalEmail.isPresent()){
            throw new IllegalStateException("Account with this mail is already created.");
        }
        //sprawdza, czy podany przez uzytkonwika login nie jest zajety
        Optional<User> userOptionalLogin = userRepository.findUserByLogin(user.getLogin());
        if (userOptionalLogin.isPresent()){
            throw new IllegalStateException("Account with this login is already created.");
        }
        userRepository.save(user);
    }

    //usuniecie uzytkownika
    public void deleteUser(Long userId) {
        userRepository.findById(userId);

        //spradza, czy uzytkownik istnieje. Jezeli nie - wypisuje komunikat
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id " + userId + " doesn't exists.");
        }
        userRepository.deleteById(userId);
    }

    //aktualizowanie maila
    @Transactional
    public void updateUsersEmail(Long userId, String email) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalStateException("User with id " + userId + " doesn't exists.")
        );

        //sprawdza czy pole nie jest puste oraz czy nowy mail nie jest zajety
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("Email is already taken.");
            }
            user.setEmail(email);
        }
    }
}
