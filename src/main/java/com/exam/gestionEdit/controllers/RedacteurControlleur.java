package com.exam.gestionEdit.controllers;

import com.exam.gestionEdit.dtos.ArticleDTO;
import com.exam.gestionEdit.dtos.UtilisateurDTO;
import com.exam.gestionEdit.enums.EtatArticle;
import com.exam.gestionEdit.services.ArticleService;
import com.exam.gestionEdit.services.NumeroService;
import com.exam.gestionEdit.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("redacteur")
public class RedacteurControlleur {

    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    NumeroService numeroService;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "loginRedacteur";
    }

    @PostMapping("login")
    public String checkLogin(UtilisateurDTO userDto, BindingResult result, Model model){
        if (utilisateurService.verifierLogin("admin", userDto.getPassword())) {
            return "redirect:/redacteur/home";
        } else {
            result.addError(new ObjectError("global","Le mot de passe ne correspond pas au compte !"));
            System.out.println(result.hasErrors());
            return "loginRedacteur";
        }
    }

    @RequestMapping("home")
    public String afficherToutArticle(Model model) {
        actualiserModel(model);
        return("interfaceRedacteur");
    }

    @PostMapping("creerNumero")
    public String creerNumero(){
        numeroService.creerNumero();
        return "redirect:/redacteur/home";
    }


    @PostMapping("publier")
    public String publierArticle(ArticleDTO articleDTO, Model model){
        articleService.publierArticle(articleDTO);
        return("redirect:/redacteur/home");
    }

    @RequestMapping("logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }

    public void actualiserModel(Model model){
        model.addAttribute(new ArticleDTO());
        model.addAttribute("etats", EtatArticle.getEtatsRedacteur());
        model.addAttribute("numerosNonBoucle", numeroService.recupererNumerosNonBoucles());
        model.addAttribute("articles",articleService.recupererArticlesPositionnes());
    }


}
