package com.example.hacksilesia.track;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {

    Track findByLink(String link);
    Track findById(Long id);
}
