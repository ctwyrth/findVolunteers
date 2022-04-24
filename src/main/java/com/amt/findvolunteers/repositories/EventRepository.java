package com.amt.findvolunteers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amt.findvolunteers.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    // this method retrieves all from the database
    List<Event> findAll();

}