package com.merlan.theater.web.application;
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

import java.time.LocalDate;
import java.util.Set;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String saveUser(@RequestParam(value="firstName", required=true)String firstName,
                           @RequestParam(value="LastName", required=false)String lastName,
                           @RequestParam(value="email", required=true)String emailString,
                           @RequestParam(value="birthday", required=false)LocalDate birthday,
                           Model model){
        User user = this.userService.saveUser(firstName, lastName, emailString, birthday, null);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value="/remove", method= RequestMethod.POST)
    public String removeUser(@RequestParam(value="email", required=true)String emailString,
                           @RequestParam(value="userId", required=false)String userId,
                           Model model){
        User user = this.userService.removeUser(emailString, userId);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String getAll(Model model){
        Set<User> users = this.userService.getAll();
        model.addAttribute("user", users);
        return "user";
    }

    @RequestMapping(value="/byId", method= RequestMethod.GET)
    public String getUserById(@RequestParam(value="userId", required=true)Long userId, Model model){
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user";
    }
    @RequestMapping(value="/byNail", method= RequestMethod.GET)
    public String getUserByEmail(@RequestParam(value="mail", required=true)String mailString, Model model){
        User user = this.userService.getUserByEmail(mailString);
        model.addAttribute("user", user);
        return "user";
   }
}
