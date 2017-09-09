package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public boolean isCorrectForm(Errors errors) {
        return !errors.hasErrors();
    }

    public Track createTrack(TrackForm trackForm) {
        String name = trackForm.getName();
        Double start_latitude = trackForm.getStart_latitude();
        Double start_longitude = trackForm.getStart_longitude();
        Double end_latitude = trackForm.getEnd_latitude();
        Double end_longitude = trackForm.getStart_longitude();
        Integer space = trackForm.getSpace();
        String telephone = trackForm.getTelephone();
        String time = trackForm.getTime();
        String other = trackForm.getOther();
        return trackRepository.save(new Track(
                name,
                start_latitude,
                start_longitude,
                end_latitude,
                end_longitude,
                space,
                telephone,
                time,
                other));
    }


    public String generateLink(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(track.getId());
        stringBuilder.append(track.getName().charAt(0));
        stringBuilder.append(track.getSpace());
        return stringBuilder.toString();

    }
}
