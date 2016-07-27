package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exception.ApplicationException;
import model.User;
import logger.Logger;
import service.UserService;

@Controller 
public class UserController {

    @Autowired
	private UserService userService;
	 
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUserData(@ModelAttribute("user") User user,
		                        	   BindingResult result) { 
        try{  
            userService.addUser(user);
	        System.out.println("Save User Data");
        } catch(ApplicationException e) {
        	Logger.writeLog(e);
            e.printStackTrace();        	
        }
	return new ModelAndView("redirect:/index.html");
	}    
}
