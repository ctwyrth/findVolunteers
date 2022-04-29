package com.amt.findvolunteers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amt.findvolunteers.models.EventPic;
import com.amt.findvolunteers.repositories.EventPicRepository;

@Service
public class EventPicService {
	@Autowired
	EventPicRepository eventPicRepository;
	
//	SHOW ALL
	public List<EventPic> allEventPics(){
		return eventPicRepository.findAll();
	}
//	CREATE
	public EventPic createEventPic(EventPic p) {
		return eventPicRepository.save(p);
	}
//	UPDATE
	public EventPic updateEventPic(EventPic p) {
		return eventPicRepository.save(p);
	}
//	SHOW ONE
	public EventPic findEventPic(Long id) {
		Optional<EventPic> optionalEventPic = eventPicRepository.findById(id);
		if (optionalEventPic.isPresent()) {
			return optionalEventPic.get();
		}
		return null;
	}
//	DELETE ONE
	public void deleteEventPic(Long id) {
		eventPicRepository.deleteById(id);
	}
}
