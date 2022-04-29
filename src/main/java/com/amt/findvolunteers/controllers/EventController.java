package com.amt.findvolunteers.controllers;

import java.util.List;

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

import com.amt.findvolunteers.models.Event;
import com.amt.findvolunteers.models.LoginUser;
import com.amt.findvolunteers.models.User;
import com.amt.findvolunteers.services.EventService;
import com.amt.findvolunteers.services.UserService;

@Controller
public class EventController {
    // -----------------------variables-----------------------
    @Autowired
    private EventService eventService;
    
    @Autowired
    private UserService userService;

    // show all no login required
    @GetMapping("/events")
    public String index(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		model.addAttribute("newUser", new User());
    		model.addAttribute("newLogin", new LoginUser());
    	    return "/events.jsp";
    	} else {
            User currentUser = userService.findUser(userId);
            List<Event> events = eventService.allEvents();
    	    model.addAttribute("events", events);
            model.addAttribute("user", currentUser);
            model.addAttribute("newUser", new User());
    		model.addAttribute("newLogin", new LoginUser());
            return "/events.jsp";
        }
    }

    // create
//    @GetMapping("/events/new")
//    public String newEvent(@ModelAttribute("event") Event event, HttpSession session) {
//        Long userId = (Long) session.getAttribute("user_id");
//    	if (userId == null) {
//    	    return "redirect:/";
//    	} else {
//            return "/events/newEvent.jsp";
//    	}
//    }
    @PostMapping("/events/new")
    public String create(@Valid @ModelAttribute("newEvent") Event newEvent, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    	    return "redirect:/";
    	} else {
    		eventService.postNew(newEvent, result);
    	    if (result.hasErrors()) {
    	    	System.out.println(result);
    	    	User currentUser = userService.findUser(userId);
        		List<Event> events = eventService.allEvents();
        		model.addAttribute("user", currentUser);
        	    model.addAttribute("events", events);
    	    	return "/dashboard.jsp";
    	    } else {
    	    	User currentUser = userService.findUser(userId);
    	    	newEvent.setPoster(currentUser);
    	    	eventService.createEvent(newEvent);
    	    	return "redirect:/dashboard";
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
            return "/events/showEvent.jsp";
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
    		eventService.postNew(event, result);
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