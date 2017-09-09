package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TrackRest {

    @Autowired
    TrackService trackService;

    @PostMapping("/track/new")
    Track addTrack(@Valid @RequestBody TrackForm trackForm, Errors errors) {
        System.out.println(trackForm.getName());

        if (trackService.isCorrectForm(errors)) {
            Track track = trackService.createTrack(trackForm);
            track.setLink(trackService.generateLink(track));
            return track;
        }
        return null;
    }
}
