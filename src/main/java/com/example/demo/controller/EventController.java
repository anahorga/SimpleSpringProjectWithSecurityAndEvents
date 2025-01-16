package com.example.demo.controller;


import com.example.demo.model.Event;
import com.example.demo.model.EventCategory;
import com.example.demo.model.Tag;
import com.example.demo.dto.EventTagDTO;
import com.example.demo.service.EventCategoryService;
import com.example.demo.service.EventService;
import com.example.demo.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {


    @Autowired//pt dependency injection
    private EventService eventService;


    //findAll,save,findById

    @Autowired
    private EventCategoryService eventCategoryService;
    @GetMapping
    public String displayAllEvents(@RequestParam(required=false) Integer categoryId, Model model)
    {
        if(categoryId==null) {
            model.addAttribute("title","All events");
            model.addAttribute("events", eventService.findAll());
        }
        else{
            Optional<EventCategory> result= eventCategoryService.findById(categoryId);
            if(result.isEmpty())
            {
                model.addAttribute("title","Invalid category Id: "+ categoryId);
            }
            else
            {
                EventCategory category=result.get();
                model.addAttribute("title","Events in category: "+category.getName());
                model.addAttribute("events",category.getEvents());
            }

        }
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model)
    {

        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories",eventCategoryService.findAll());
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model)
    {
        if(errors.hasErrors()) {
            model.addAttribute("title","Create Event");
            return "events/create";
        }

        eventService.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteForm(Model model)
    {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",eventService.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required=false) int[] eventIds)
    {
        if(eventIds!=null)
        {
            for(int id:eventIds)
                eventService.deleteById(id);
        }

        return "redirect:/events";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId,Model model)
    {
        Optional <Event> result=eventService.findById(eventId);

        if(result.isEmpty())
        {
            model.addAttribute("title","Invalid Event ID: "+eventId);
        }
        else {
            Event event=result.get();
            model.addAttribute("title",event.getName()+" Details");
            model.addAttribute("event",event);
            model.addAttribute("tags",event.getTags());
        }
        return "events/detail";
    }
    @Autowired
    private TagService tagService;

    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam  Integer eventId,Model model)
    {
        Optional<Event> result=eventService.findById(eventId);
        Event event=result.get();
        model.addAttribute("title","Add Tag to: "+ event.getName());
        model.addAttribute("tags", tagService.findAll());

        EventTagDTO eventTag=new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag",eventTag);
        return "events/add-tag";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag,Errors errors ,Model model){

        if(!errors.hasErrors())
        {
            Event event = eventTag.getEvent();
            Tag tag = eventTag.getTag();

            if(!event.getTags().contains(tag))
            {
                event.addTag(tag);
                eventService.save(event);
            }
            return "redirect:/events/detail?eventId= "+event.getId();
        }
        return "redirect:/events/add-tag";
    }

}
