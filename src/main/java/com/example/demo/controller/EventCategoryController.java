package com.example.demo.controller;


import com.example.demo.model.EventCategory;
import com.example.demo.service.EventCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired//pt dependency injection
    private EventCategoryService categoryService;
    @GetMapping
    public String displayAllCategories(Model model)
    {
        model.addAttribute("categories", categoryService.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String displayCreateEventCategoryForm(Model model)
    {

        model.addAttribute("title","Create Category");
        model.addAttribute("category",new EventCategory());
        return "eventCategories/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newCategory, Errors errors, Model model)
    {
        if(errors.hasErrors()) {
            model.addAttribute("title","Create Category");
            return "eventCategories/create";
        }

        categoryService.save(newCategory);
        return "redirect:/eventCategories";
    }
}
