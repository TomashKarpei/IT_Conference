package com.zadanie.IT_Conference.Conference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/api/conference")
public class ConferenceController {
    private final ConferenceService conferenceService;
    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping
    public List<Conference> getConference(){
        return conferenceService.getConference();
    }
}
