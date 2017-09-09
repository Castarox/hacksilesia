package com.example.hacksilesia.track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrackController {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackService trackService;

    @GetMapping("track/{link}")
    String edit(@PathVariable String link, Model model){
        Track track = trackRepository.findByLink(link);
        if (track != null){
            model.addAttribute("track", track);
            return "edit-form";
        }
        return null;
    }


    @GetMapping("/track/new")
    String form() {
        return "form";
    }

    @GetMapping("/passenger")
    String form_passenger() {
        return "form-passenger";
    }
}
