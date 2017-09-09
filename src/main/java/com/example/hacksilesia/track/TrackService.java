package com.example.hacksilesia.track;

import com.example.hacksilesia.form.TrackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.*;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getTrackByDystance(double lat, double lng, float distance) {
        return trackRepository.findAll();
//        double maxLatitude = latitude + distance;
//        double minLatitude = latitude - distance;
//        double maxLongitude = longitude + distance;
//        double minLongitude = longitude - distance;
//        return trackRepository.findByStartLatitudeLessThanEqualAndStartLatitudeIsGreaterThanEqualAndStartLongitudeIsLessThanEqualAndStartLongitudeGreaterThanEqual(maxLatitude, minLatitude, maxLongitude, minLongitude);
    }

    public boolean isCorrectForm(Errors errors) {
        return !errors.hasErrors();
    }

    public Track createTrack(TrackForm trackForm) {
        String name = trackForm.getName();
        String startCity = trackForm.getStartCity();
        String endCity = trackForm.getEndCity();
        Integer space = trackForm.getSpace();
        String telephone = trackForm.getTelephone();
        String time = trackForm.getTime();
        String other = trackForm.getOther();
        return trackRepository.save(new Track(
                name,
                startCity,
                endCity,
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

    public Track editTrack(Track track, TrackForm trackForm){
        track.setName(trackForm.getName());
        track.setSpace(trackForm.getSpace());

        track.setStartCity(trackForm.getStartCity());
        track.setEndCity(trackForm.getEndCity());

        track.setTelephone(trackForm.getTelephone());
        track.setSpace(trackForm.getSpace());

        track.setTime(trackForm.getTime());
        track.setOther(trackForm.getOther());
        return this.save(track);

    }

    public void removeTrack(Track track){
        trackRepository.delete(track);
    }

    public Track save(Track track) {
       return trackRepository.save(track);
    }
}
