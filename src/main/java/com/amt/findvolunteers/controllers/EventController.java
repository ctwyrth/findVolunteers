package com.amt.findvolunteers.controllers;

import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.amt.findvolunteers.models.Event;
<<<<<<< Updated upstream
=======
import com.amt.findvolunteers.models.EventPic;
import com.amt.findvolunteers.models.LoginUser;
>>>>>>> Stashed changes
import com.amt.findvolunteers.models.User;
import com.amt.findvolunteers.services.EventPicService;
import com.amt.findvolunteers.services.EventService;
import com.amt.findvolunteers.services.UserService;

@Controller
public class EventController {
    // -----------------------variables-----------------------
    @Autowired
    private EventService eventService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private EventPicService eventPicService;

    // show all
    @GetMapping("/events") // home or dashboard
    public String index(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
            User currentUser = userService.findUser(userId);
            List<Event> events = eventService.allEvents();
    	    model.addAttribute("events", events);
            model.addAttribute(currentUser);
            return "/events/showEvents.jsp";
        }
    }

    // create
    @GetMapping("/events/new")
    public String newEvent(@ModelAttribute("event") Event event, 
    		HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
            return "/events/newEvent.jsp";
    	}
    }
    //    create with image save
    @PostMapping("/events/new")
    public String create(@Valid @ModelAttribute("event") Event event, BindingResult result, 
    		HttpSession session, 
    		@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
    	    if (result.hasErrors()) {
    	    	return "/events/newEvent.jsp";
    	    } else {
    	    	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    	    	if (fileName != null) {
    	    		EventPic eventPic = new EventPic();
    	    		eventPic.setPic(fileName);
    	    		EventPic savedEventPic = eventPicService.createEventPic(eventPic);
// ??? NEED TO DOUBLE CHECK HOW TO ADDRESS FOLDER   	    		
    	    		String uploadDir = "./upload/" + savedEventPic.getId();
    	    		
    	    		Path uploadPath = Paths.get(uploadDir);
    	    		
    	    		if (!Files.exists(uploadPath)) {
    	    			Files.createDirectories(uploadPath);
    	    		}
    	    		
//   regarding multipart form
    	    		try (InputStream inputStream = multipartFile.getInputStream()) {
    	    			//    	construct file path
    	    			Path filePath = uploadPath.resolve(fileName);
    	    			
    	    			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    	    		} catch (IOException e) {
    	    			throw new IOException("Could not save uploaded file: "+ fileName);
    	    		}
    	    	User currentUser = userService.findUser(userId);
    	    	event.setPoster(currentUser);
    	    	eventService.createEvent(event);
<<<<<<< Updated upstream
    	    	return "redirect:/events";
=======
//    	    	event picture save
    	    	savedEventPic.setEvent(event);
    	    	eventPicService.updateEventPic(savedEventPic);
    	    	return "redirect:/dashboard";
//    	    	if no event pic
    	    	}else {
    	    	  	User currentUser = userService.findUser(userId);
        	    	event.setPoster(currentUser);
        	    	eventService.createEvent(event);
        	    	return "redirect:/dashboard";
    	    	}
>>>>>>> Stashed changes
    	    }
        }
    }

    // display one found by id
    @GetMapping("/events/{id}")
    public String showOneeventById(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
            Event eventToShow = eventService.findEvent(id);
            model.addAttribute("event", eventToShow);
//            ***needs to be updated
	    return "/events/show.jsp";
        }
    }

    // update one found by id
    @GetMapping("/events/{id}/edit")
    public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
    	    Event eventToShow = eventService.findEvent(id);
            if (userId.equals(eventToShow.getPoster().getId())) {
            	model.addAttribute("event", eventToShow);
            	return "/events/edit.jsp";
            } else {
            	return "redirect:/events";
            }
        }
    }
    @PutMapping("/events/{id}/edit")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
    		if (result.hasErrors()) {
    			return "/events/edit.jsp";
    		} else {
    			Event eventToEdit = eventService.findEvent(id);
    			if (userId.equals(eventToEdit.getPoster().getId())) {
    		    eventService.updateEvent(event);
    		    return "redirect:/events";
    		} else {
    		    return "redirect:/home";
    		}
	    }
        }
    }

    // delete one
    @DeleteMapping("/events/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
            Event eventToDelete = eventService.findEvent(id);
    		if (userId.equals(eventToDelete.getPoster().getId())) {
            	eventService.deleteEvent(id);
            	return "redirect:/events";
    		} else {
                    return "redirect:/home";
                }
            }
    }
}