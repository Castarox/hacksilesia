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

    public List<Track> getTrackByDystance(double latitude, double longitude, float distance) {
        double maxLatitude = latitude + distance;
        double minLatitude = latitude - distance;
        double maxLongitude = longitude + distance;
        double minLongitude = longitude - distance;
        return trackRepository.findByStartLatitudeLessThanEqualAndStartLatitudeIsGreaterThanEqualAndStartLongitudeIsLessThanEqualAndStartLongitudeGreaterThanEqual(maxLatitude, minLatitude, maxLongitude, minLongitude);
    }

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

    public Track editTrack(Track track, TrackForm trackForm){
        track.setName(trackForm.getName());
        track.setSpace(trackForm.getSpace());

        track.setStartLatitude(trackForm.getStart_latitude());
        track.setStartLongitude(trackForm.getStart_longitude());

        track.setEndLatitude(trackForm.getEnd_latitude());
        track.setEndLongitude(trackForm.getEnd_longitude());

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
