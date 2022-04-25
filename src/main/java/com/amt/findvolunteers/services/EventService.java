package com.amt.findvolunteers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
    
    // validate ancillary fields
    public Event postNew(Event event, BindingResult result) {
    	if (event.getNeeded() != null) {
    		if (event.getNeeded() < 0) {
    			result.rejectValue("needed", "Positive", "Volunteers needed can not be negative.");
    		}
    	}
    	if (event.getAddress() != null) {
    		if (event.getAddress().length() < 10 || event.getAddress().length() > 128) {
    			result.rejectValue("address", "Length", "Address should be between 10 and 128 characters long.");
    		}
    	}
    	if (event.getAddress2() != null) {
    		if (event.getAddress2().length() < 10 || event.getAddress2().length() > 128) {
    			result.rejectValue("address", "Length", "Address should be between 5 and 50 characters long.");
    		}
    	}
    	if (event.getCity() != null) {
    		if (event.getCity().length() < 3 || event.getCity().length() > 128) {
    			result.rejectValue("city", "Length", "City should be between 3 and 128 characters long.");
    		}
    	}
    	if (event.getState() != null) {
    		if (event.getState().length() < 2 || event.getState().length() > 128) {
    			result.rejectValue("city", "Length", "State should be between 3 and 128 characters long.");
    		}
    	}
    	return event;
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