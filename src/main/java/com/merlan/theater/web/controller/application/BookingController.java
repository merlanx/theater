package com.merlan.theater.web.controller.application;

import com.merlan.theater.business.service.BookingService;
import com.merlan.theater.data.entity.Event;
import com.merlan.theater.data.entity.Ticket;
import com.merlan.theater.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/ticket")
public class BookingController {

    @Autowired
    private BookingService bookingtService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String getAllTicetsForDate(@RequestParam(value="date", required=true)String dateString, Model model){
        List<Ticket> ticketList = this.bookingtService.getAllTicketsForDate(dateString);
        model.addAttribute("ticket", ticketList);
        return "ticket";
    }

    @RequestMapping(value="/prices", method= RequestMethod.GET)
    public String getTicketsPrices(@RequestParam(value="moiveName", required=true)String moiveName,
                                   @RequestParam(value="date", required=true)String dateString,
                                   @RequestParam(value="userName", required=false)String userName,
                                   @RequestParam(value="seats", required=false)List<Long> seatsString,
                                   Model model){
            Event event = new Event();
            User user = new User();
            List<Long> seats = new ArrayList<>();
            double totalPrices = this.bookingtService.getTicketsPrice(event, user, seats);
            model.addAttribute("ticket", totalPrices);
            return "ticket";
        }

    @RequestMapping(value="/booking",method= RequestMethod.POST)
    public String bookTickets(@RequestParam(value="moiveName", required=true)String moiveName,
                                   @RequestParam(value="date", required=true)String dateString,
                                   @RequestParam(value="userName", required=false)String userName,
                                   @RequestParam(value="seats", required=false)List<Long> seatsString,
                                   Model model){
        Event event = new Event();
        User user = new User();
        List<Long> seats = new ArrayList<>();
        List<Ticket> tickets = this.bookingtService.bookTickets(event, user, seats);
        model.addAttribute("ticket", tickets);
        return "ticket";
    }

    @RequestMapping(value="/purchased", method= RequestMethod.GET)
    public String getPurchasedTicketsForEvent(@RequestParam(value="moiveName", required=true)String moiveName,
                                              @RequestParam(value="date", required=true)String dateString,
                                              Model model){
        Event event = new Event();
        List<Ticket> tickets = this.bookingtService.getPurchasedTicketsForEvent(event);
        model.addAttribute("ticket", tickets);
        return "ticket";
    }
}
