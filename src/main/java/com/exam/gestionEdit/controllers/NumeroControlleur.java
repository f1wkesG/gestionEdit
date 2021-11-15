package com.exam.gestionEdit.controllers;

import com.exam.gestionEdit.services.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("numeros")
public class NumeroControlleur {

    @Autowired
    NumeroService numeroService;

    @RequestMapping("")
    public String afficherTout(Model model) {
        model.addAttribute("numeros", numeroService.recupererNumerosBoucles());
        return "interfaceNumero";
    }

    @RequestMapping("numero")
    public String afficherArticleParNumero(@RequestParam(name = "num") int numero, Model model) {
        model.addAttribute("articles", numeroService.recupererNumero(numero).getArticles());
        return "articlesParNumero";
    }
}
