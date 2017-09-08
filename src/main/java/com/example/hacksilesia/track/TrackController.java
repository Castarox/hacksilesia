package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("")
    String index() {
        return "index";
    }

    @GetMapping("/track/new")
    String form() {
        return "form";
    }


    @PostMapping("/track/new")
    @ResponseBody
    Track addTrack(@ModelAttribute("form") @Valid TrackForm trackForm, BindingResult result) {
        if (trackService.isCorrectForm(result)) {
            Track track = trackService.createTrack(trackForm);
            track.setLink(trackService.generateLink(track));
            return track;
        }
        return null;
    }
}
