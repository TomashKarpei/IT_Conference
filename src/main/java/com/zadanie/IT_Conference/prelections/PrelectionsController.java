package com.zadanie.IT_Conference.prelections;

import com.zadanie.IT_Conference.user.User;
import com.zadanie.IT_Conference.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/prelections")
public class PrelectionsController {

    private final PrelectionService prelectionService;
    @Autowired
    public PrelectionsController(PrelectionService prelectionService) {
        this.prelectionService = prelectionService;
    }

    @GetMapping
    public List<Prelections> getPrelections(){
        return prelectionService.getPrelections();
    }


//    @GetMapping()
//    public Prelections getPrelections(){
//        return 0;
//    }
}
