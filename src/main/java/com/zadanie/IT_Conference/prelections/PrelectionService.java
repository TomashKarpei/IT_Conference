package com.zadanie.IT_Conference.prelections;

import com.zadanie.IT_Conference.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrelectionService {
    private final PrelectionsRepository prelectionsRepository;

    @Autowired
    public PrelectionService(PrelectionsRepository prelectionsRepository){
        this.prelectionsRepository = prelectionsRepository;
    }


    public List<Prelections> getPrelections() {
        return prelectionsRepository.findAll();
    }
}
