package com.merlan.theater.web.controller.service;

import com.merlan.theater.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/api")
public class PdfServiceController {

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET, value="/download/pdf/{serviceName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ModelAndView getAllData(@PathVariable(value="serviceName")String serviceName){
        ModelAndView modelAndView = new ModelAndView("PdfView", serviceName,this.userService.getAll());

        return modelAndView;


    }


}
