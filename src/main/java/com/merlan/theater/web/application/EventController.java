package com.merlan.theater.web.application;
/**
 * @author
 */
/**
 * TODO: TO ADD FUNCTION
 */
import com.merlan.theater.business.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping(value="/Ticket")
public class EventController {

    @Autowired
    private BookingService bookingtService;

//    @RequestMapping(method= RequestMethod.GET)
//    public String getTicket(@RequestParam(value="date", required=false)String dateString, Model model){
//        /*List<Ticket> ticketList = this.bookingtService.getTicketsForDate(dateString);
//        model.addAttribute("ticket", ticketList);*/
//        return "tickets";
//    }
}
