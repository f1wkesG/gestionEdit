package com.exam.gestionEdit.controllers;

import com.exam.gestionEdit.services.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginControlleur {

    @Autowired
    NumeroService numeroService;

    @RequestMapping("")
    public String toLogin(Model model) {
        return("welcome");
    }

}
