package com.exam.gestionEdit.controllers;

import com.exam.gestionEdit.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginControlleur {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("")
    public String toLogin() {
        return("welcome");
    }

}
