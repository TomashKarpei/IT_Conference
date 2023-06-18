package com.zadanie.IT_Conference.Conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getConference(){
        return conferenceRepository.findAll();
    }
}
