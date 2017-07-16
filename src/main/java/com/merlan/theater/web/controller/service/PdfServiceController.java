package com.merlan.theater.web.controller.service;

import com.merlan.theater.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/api")
public class PdfServiceController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/download/{serviceName}_all",method= RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public String getAllData(@PathVariable(value="serviceName")String serviceName, Model model){
   // public ModelAndView getAllData(@PathVariable(value="serviceName")String serviceName, HttpServletRequest request,
     //           HttpServletResponse response){
        model.addAttribute(serviceName + "_all", new ArrayList(this.userService.getAll()));
        //ModelAndView modelAndView = new ModelAndView("PdfView", serviceName + "_all",new ArrayList(this.userService.getAll()));

        return "";


    }


}
