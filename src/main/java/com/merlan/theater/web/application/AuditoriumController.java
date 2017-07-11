package com.merlan.theater.web.application;
/**
 * @author meilan_xie
 */

import com.merlan.theater.business.service.AuditoriumService;
import com.merlan.theater.data.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping(value="/auditorium")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String getAll(Model model){
        Set<Auditorium> auditoriums = this.auditoriumService.getAll();
        model.addAttribute("auditorium", auditoriums);
        return "auditorium";
    }

    @RequestMapping(value="/byName", method= RequestMethod.GET)
    public String getAuditoriumByName(@RequestParam(value="name", required=true)String name, Model model){
        Auditorium auditorium = this.auditoriumService.getByName(name);
        model.addAttribute("auditorium", auditorium);
        return "auditorium";
    }

}
