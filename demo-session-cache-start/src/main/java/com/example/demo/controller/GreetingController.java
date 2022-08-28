package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GreetingController
{

    @RequestMapping("/greeting")
    public String greeting(Model model, HttpServletRequest request)
    {

        String name = (String) request.getSession().getAttribute("name");

        if (name == null)
        {
            log.info("No Sesion available!  Not logged in");
            return "login";
        }
        else
        {
            log.info("Hey already logged in! " + name);
            model.addAttribute("name", name);
            return "greeting";
        }
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String whoareyou(@RequestParam(value = "name", required = true) String name, Model model, HttpServletRequest request)
    {

        log.info("Entered user name " + name);
        request.getSession().setAttribute("name", name); // Set stuff in session

        //add stuff into model for the HTMls
        model.addAttribute("name", name);
        return "greeting";

    }
    
    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


}
