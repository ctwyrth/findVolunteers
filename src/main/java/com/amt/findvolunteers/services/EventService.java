package com.amt.findvolunteers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amt.findvolunteers.models.Event;
import com.amt.findvolunteers.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    
    // shows all
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }

    // creates one
    public Event createEvent(Event e) {
        return eventRepository.save(e);
    }

    // retrieves one by id
    public Event findEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }

    // updates one
    public Event updateEvent(Event e) {
       	return eventRepository.save(e);
    }
    
    // deletes one
    public void deleteEvent(Long id) {
    	eventRepository.deleteById(id);
    }
}