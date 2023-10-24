package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Patron;
import com.example.librarymanagementsystem.service.interfaces.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patrons")
public class PatronController {
    private PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping("/manage")
    public String patronIndex(Model model){
        model.addAttribute("patronList", patronService.getAllPatrons());

        return "patron/manage";
    }

    @GetMapping("/createForm")
    public String patronForm(Model model){
        model.addAttribute("patron", new Patron());

        return "patron/form";
    }

    @PostMapping("/save")
    public String createPatron(@Valid @ModelAttribute("patron") Patron patron, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "patron/form";
        }else {
            patronService.savePatron(patron);
            return "redirect:/patrons/list";
        }
    }

    @GetMapping("/updateForm")
    public String updatePatron(@RequestParam("patronId") int patronId, Model model){
        Patron dbPatron = patronService.getPatronById(patronId);
        model.addAttribute(dbPatron);
        return "patron/form";
    }

    @GetMapping("/delete")
    public String deletePatron(@RequestParam("patronId") int patronId){
        patronService.deletePatron(patronId);
        return "redirect:/patrons/manage";
    }

    @InitBinder
    public void initBinder (WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
