package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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


    @GetMapping("/passenger/start/{lat}/{lng}/{distance}")
    List<Track> availableTracks(@PathVariable double lat,
                                @PathVariable double lng,
                                @PathVariable float distance) {
        return trackService.getTrackByDystance(lat, lng, distance);
    }
}
