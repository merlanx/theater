package com.merlan.theater.web.controller.application;
/**
 * @author meilan_xie
 */

import com.merlan.theater.business.service.UserService;
import com.merlan.theater.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/save", method= RequestMethod.GET)
    public String saveUser(@RequestParam(value="firstName", required=true)String firstName,
                           @RequestParam(value="LastName", required=false)String lastName,
                           @RequestParam(value="email", required=true)String email,
                           @RequestParam(value="birthday", required=false)Date birthday,
                           @RequestParam(value="boughtTickets", required=false)int boughtTickets,
                           Model model){
        User user = new User(firstName, lastName, email, birthday, boughtTickets);
        this.userService.saveUser(user);
        model.addAttribute("users", user);
        return "user";
    }

    @RequestMapping(value="/remove/byEmail", method= RequestMethod.GET)
    public String removeUser(@RequestParam(value="email", required=true)String emailString,
                           Model model){
        User user = this.userService.removeUser(emailString);
        model.addAttribute("users", user);
        return "user";
    }
    @RequestMapping(value="/remove/byId", method= RequestMethod.GET)
    public String removeUser(@RequestParam(value="userId", required=false)Long userId,
                          Model model){
        User user = this.userService.removeUser(userId);
        model.addAttribute("users", user);
        return "user";
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String getAll(Model model){
        Set<User> users = this.userService.getAll();
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping(value="/byId", method= RequestMethod.GET)
    public String getUserById(@RequestParam(value="userId", required=true)Long userId, Model model){
        List<User> users = new ArrayList<>(1);
        users.add(this.userService.getUserById(userId));
        model.addAttribute("users", users);
        return "user";
    }
    @RequestMapping(value="/byEmail", method= RequestMethod.GET)
    public String getUserByEmail(@RequestParam(value="email", required=true)String email, Model model){
        List<User> user = this.userService.getUserByEmail(email);
        model.addAttribute("users", user);
        return "user";
   }
    @RequestMapping(value="/byEmails", method= RequestMethod.GET)
    public String getUserByEmails(@RequestParam(value="emails", required=true) String[] emails, Model model){
        List<User> users = this.userService.getUserByEmail(emails);
        model.addAttribute("users", users);
        return "user";
    }
}
