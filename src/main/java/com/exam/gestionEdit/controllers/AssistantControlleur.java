package com.exam.gestionEdit.controllers;


import com.exam.gestionEdit.dtos.ArticleDTO;
import com.exam.gestionEdit.dtos.UtilisateurDTO;
import com.exam.gestionEdit.enums.EtatArticle;
import com.exam.gestionEdit.enums.Theme;
import com.exam.gestionEdit.exceptions.ContributeurAlreadyExists;
import com.exam.gestionEdit.services.ArticleService;
import com.exam.gestionEdit.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("assistant")
public class AssistantControlleur {

    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "loginAssistant";
    }

    @PostMapping("login")
    public String checkLogin(UtilisateurDTO userDto, BindingResult result, Model model){
        if (utilisateurService.verifierLogin("assistant", userDto.getPassword())) {
            return "redirect:/assistant/home";
        } else {
            result.addError(new ObjectError("global","Le mot de passe ne correspond pas au compte !"));
            System.out.println(result.hasErrors());
            return "loginAssistant";
        }
    }

    @RequestMapping("home")
    public String afficherToutArticle(Model model) {
        actualiserModel(model);
        return("interfaceAssistant");
    }

    @PostMapping("modifierEtat")
    public String modifierEtat(ArticleDTO articleDTO, Model model) {
        articleService.modifierEtat(articleDTO);
        return("redirect:/assistant/home");
    }

    @PostMapping("modifierArticle")
    public String modifierArticle(ArticleDTO articleDTO, Model model) {
        articleService.modifierContenu(articleDTO);
        return("redirect:/assistant/home");
    }

    @PostMapping("modification")
    public String modifierContenu(ArticleDTO articleDTO, Model model) {
        model.addAttribute("article", articleDTO);
        return("modifierArticle");
    }

    @RequestMapping("logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }

    public void actualiserModel(Model model){
        model.addAttribute(new ArticleDTO());
        model.addAttribute("etats", EtatArticle.getEtatsAssistant());
        model.addAttribute("articles",articleService.recupererArticlesNonBoucles());
        model.addAttribute("articlesRejetes", articleService.recupererArticlesRejetes());
        model.addAttribute("articlesModifies", articleService.recupererArticlesModifies());
        model.addAttribute("articlesValides", articleService.recupererArticlesModifiesValides());
        model.addAttribute("articlesRefuses", articleService.recupererArticlesModifiesRefuses());
    }
}
