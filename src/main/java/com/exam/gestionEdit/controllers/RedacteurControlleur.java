package com.exam.gestionEdit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redacteur")
public class RedacteurControlleur {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

}
