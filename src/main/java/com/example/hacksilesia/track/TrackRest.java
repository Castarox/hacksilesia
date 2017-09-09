package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TrackRest {
    @Autowired
    TrackRepository trackRepository;

    @Autowired
    TrackService trackService;

    @PostMapping("/track/new")
    Track addTrack(@Valid @RequestBody TrackForm trackForm, Errors errors) {
        System.out.println(trackForm.getName());

        if (trackService.isCorrectForm(errors)) {
            Track track = trackService.createTrack(trackForm);
            track.setLink(trackService.generateLink(track));
            trackService.save(track);
            return track;
        }
        return null;
    }

    @PostMapping("track/{link}")
    Track editTrack(@Valid @RequestBody TrackForm trackForm, Errors errors, @PathVariable String link){
        if (trackService.isCorrectForm(errors)) {
            Track track = trackRepository.findByLink(link);
            trackService.editTrack(track, trackForm);
            return track;
        }
        return null;
    }
}
