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

    public List<Track> getTrackByDystance(String latitude, String longitude, float distance) {
        double maxLatitude = Double.parseDouble(latitude) + distance;
        double minLatitude = Double.parseDouble(latitude) - distance;
        double maxLongitude = Double.parseDouble(longitude) + distance;
        double minLongitude = Double.parseDouble(longitude) - distance;
        return trackRepository.findByStartLatitudeLessThanEqualAndStartLatitudeIsGreaterThanEqualAndStartLongitudeIsLessThanEqualAndStartLongitudeGreaterThanEqual(String.valueOf(maxLatitude), String.valueOf(minLatitude), String.valueOf(maxLongitude), String.valueOf(minLongitude));
    }

    public boolean isCorrectForm(Errors errors) {
        return !errors.hasErrors();
    }

    public Track createTrack(TrackForm trackForm) {
        String name = trackForm.getName();
        String start_latitude = trackForm.getStart_latitude();
        String start_longitude = trackForm.getStart_longitude();
        String end_latitude = trackForm.getEnd_latitude();
        String end_longitude = trackForm.getStart_longitude();
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
        System.out.println("\n\n\n\n\nW save method");
        System.out.println(track.getStartLongitude());
        System.out.println(track.getStartLatitude());
        System.out.println("End");
        System.out.println(track.getEndLongitude());
        System.out.println(track.getEndLatitude());
       return trackRepository.save(track);
    }
}
