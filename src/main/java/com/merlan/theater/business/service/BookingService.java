package com.merlan.theater.business.service;

import com.merlan.theater.data.entity.Event;
import com.merlan.theater.data.entity.Ticket;
import com.merlan.theater.data.entity.User;
import com.merlan.theater.data.repository.EventRepository;
import com.merlan.theater.data.repository.PricingStrategyRepository;
import com.merlan.theater.data.repository.TicketRepository;
import com.merlan.theater.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author meilan_xie
 */
@Service
public class BookingService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PricingStrategyRepository pricingStrategyRepository;
    @Autowired
    private TicketRepository ticketRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Get all available/unsold tickets for event for specific date and Time
     **/
    public @Nullable List<Ticket> getAllTicketsForDate(String dateString){
        return null;
    }
    /**
    * Get total price for buying all tickets for specified event on specific date and time for specified seats.
    **/
    public double getTicketsPrice(@Nonnull Event event,  @Nullable User user, @Nonnull List<Long> seats){
        return 0.00;
    }
    /**
    * Ticket should contain information about event, air dateTime, seat, and user.
    * The user could be registered or not.
    * If user is registered, then booking information is stored for that user (in the tickets collection).
    * Purchased tickets for particular event should be stored.
    **/
    public  @Nullable List<Ticket> bookTickets(@Nonnull Event event,  @Nullable User user,  @Nullable List<Long> seats) {

        return null;
    }
    /**
    * Get all purchased tickets for event for specific date and Time
    **/
    public  @Nullable List<Ticket> getPurchasedTicketsForEvent(@Nullable Event event) {

    return null;
}
    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
