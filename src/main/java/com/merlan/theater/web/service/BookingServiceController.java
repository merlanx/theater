package com.merlan.theater.web.service;

import com.merlan.theater.business.service.BookingService;
import com.merlan.theater.data.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class BookingServiceController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(method= RequestMethod.GET, value="/booking/{date}")
    public List<Ticket> getAllTikcetsForDate(@PathVariable(value="date")String dateString){
        return this.bookingService.getAllTicketsForDate(dateString);

    }


}
