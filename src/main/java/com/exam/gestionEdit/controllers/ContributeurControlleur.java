package com.exam.gestionEdit.controllers;


import com.exam.gestionEdit.dtos.ArticleDTO;
import com.exam.gestionEdit.dtos.UtilisateurDTO;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("courant")
@RequestMapping("/contributeur")
public class ContributeurControlleur {

    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "loginContributeur";
    }

    @RequestMapping("inscription")
    public String inscrire(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "inscription";
    }

    @PostMapping("inscription")
    public String ajouterContributeur(UtilisateurDTO userDto, BindingResult result, Model model){
        try{
          utilisateurService.ajouterContributeur(userDto);
        }catch (ContributeurAlreadyExists c){
            System.out.println(c.getMessage());
            result.addError(new ObjectError("global","Le login existe deja !"));
        }
        if(result.hasErrors()){
            return "inscription";
        }else {
            return "loginContributeur";
        }

    }

    @PostMapping("login")
    public String checkLogin(UtilisateurDTO userDto, BindingResult result, Model model){
        if (utilisateurService.verifierLogin(userDto.getLogin(), userDto.getPassword())) {
            model.addAttribute("courant", userDto.getLogin());
            model.addAttribute("themes", Theme.getThemes());
            return "redirect:/contributeur/home";
        } else {
            System.out.println("I am heere !!");
            result.addError(new ObjectError("global","Les informations saisies ne correspondent pas à un utilisateur connu."));
            System.out.println(result.hasErrors());
            return "loginContributeur";
        }
    }

    @RequestMapping("home")
    public String afficherInterface(Model model, @SessionAttribute String courant) {
        model.addAttribute("courant", courant);
        model.addAttribute("articlesUtilisateur",utilisateurService.recupererArticlesParContributeur(courant));
        model.addAttribute("articlesModifies",utilisateurService.recupererArticlesModifiesParContributeur(courant));
        model.addAttribute("themes", Theme.getThemes());
        return("interfaceContributeur");
    }

    @PostMapping("articles")
    public String ajouterArticle(ArticleDTO articleDTO, Model model, @SessionAttribute String courant) {
        articleService.proposerArticle(courant, articleDTO.getTitre(), articleDTO.getContenu(), articleDTO.getTheme());
        return("redirect:/contributeur/home");
    }

    @PostMapping("refuser")
    public String refuser(ArticleDTO articleDTO){
        articleService.refuserModification(articleDTO);
        return "redirect:/contributeur/home";
    }

    @PostMapping("valider")
    public String valider(ArticleDTO articleDTO){
        articleService.validerModification(articleDTO);
        return "redirect:/contributeur/home";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }

}
