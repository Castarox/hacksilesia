package com.example.hacksilesia.track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public boolean isCorrectForm(BindingResult result) {
        return result.hasErrors();
    }
}
