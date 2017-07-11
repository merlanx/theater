package com.merlan.theater.web.application;
/**
 * @author
 */
/**
 * TODO: TO ADD FUNCTION
 */
import com.merlan.theater.business.service.UserService;
import com.merlan.theater.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public String getUserByEmail(@RequestParam(value="mail", required=false)String mailString, Model model){
        User user = this.userService.getUserByEmail(mailString);
        model.addAttribute("user", user);
        return "user";
   }
}
