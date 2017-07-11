package com.merlan.theater.web.application;
/**
 * @author meilan_xie
 */

import com.merlan.theater.business.domain.EventRating;
import com.merlan.theater.business.service.EventService;
import com.merlan.theater.data.entity.Auditorium;
import com.merlan.theater.data.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Controller
@RequestMapping(value="/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String saveEvent(@RequestParam(value="movieName", required=true)String movieName,
                           @RequestParam(value="rating", required=false)String rating,
                           @RequestParam(value="airDate", required=true)LocalDateTime airDate,
                           @RequestParam(value="auditoriumName", required=true)String auditoriumName,
                           @RequestParam(value="basePrice", required=true)Double basePrice,
                           Model model){
        Auditorium auditorium = new Auditorium();
        Event event = this.eventService.saveEvent(movieName, EventRating.valueOf(rating), airDate, auditorium, basePrice);
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value="/remove", method= RequestMethod.POST)
    public String removeEvent(@RequestParam(value="movieName", required=true)String movieName,
                              @RequestParam(value="rating", required=false)String rating,
                              @RequestParam(value="airDate", required=true)LocalDateTime airDate,
                              @RequestParam(value="auditoriumName", required=true)String auditoriumName,
                              @RequestParam(value="eventId", required=false)Long eventId,
                           Model model){
        Auditorium auditorium = new Auditorium();
        Event event = this.eventService.removeEvent(movieName, EventRating.valueOf(rating), airDate,auditorium.getId(),eventId);
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String getAll(Model model){
        Set<Event> events = this.eventService.getAll();
        model.addAttribute("event", events);
        return "event";
    }

    @RequestMapping(value="/byId", method= RequestMethod.GET)
    public String getEventById(@RequestParam(value="eventId", required=true)Long eventId, Model model){
        Event event = this.eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "event";
    }
    @RequestMapping(value="/byName", method= RequestMethod.GET)
    public String getEventByName(@RequestParam(value="movieName", required=true)String movieName, Model model){
        Set<Event> events = this.eventService.getEventByName(movieName);
        model.addAttribute("event", events);
        return "event";
   }

    @RequestMapping(value="/byDateRange", method= RequestMethod.GET)
    public String getEventByDates(@RequestParam(value="fromDate", required=true)LocalDate fromDate,
                                  @RequestParam(value="toDate", required=true)LocalDate toDate,
                                  Model model){
        Set<Event> events = this.eventService.getEventForDateRange(fromDate, toDate);
        model.addAttribute("event", events);
        return "event";
   }
    @RequestMapping(value="/byEndDate", method= RequestMethod.GET)
    public String getEventByDates(@RequestParam(value="toDate", required=true)LocalDate toDate,
                                  Model model){
        Set<Event> events = this.eventService.getEventNextEvents(toDate);
        model.addAttribute("event", events);
        return "event";
    }
}
