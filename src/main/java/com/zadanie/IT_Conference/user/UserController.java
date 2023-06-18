package com.zadanie.IT_Conference.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    //Dodawanie użytkownika do tabeli users
    //        POST localhost:8080/api/users
    //        {
    //                "firstName": "Grzegorz",
    //                "lastName": "Marcinczyk",
    //                "login": "grzegorz99",
    //                "password":"1234",
    //                "email": "grzegorzM@gmail.com",
    //                "dateOfBirth" : "1999-02-27"
    //        }
    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    // Usunięcie użytkownika z tabeli users
                                     //{id_uzytkownika}
    // DELETE localhost:8080/api/users/6
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    //Zmiana maila
    //                             {id_uzytkownika}?email={nowy_email}
    // PUT localhost:8080/api/users/5?email=mat@gmail.com
    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String email
                           ){
            userService.updateUsersEmail(userId, email);
    }

}
