package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Event extends AbstractEntity{

    @NotBlank(message="Name is required")
    @Size(min=3,max=50,message="Name mush be between 3 and 50 characters")
    private String name;


    @ManyToOne
    @NotNull(message="Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags=new ArrayList<>();

    public Event(String name,String description,String contactEmail,EventCategory eventCategory) {

        this.name = name;
        this.eventCategory=eventCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Event() {
    }

    @OneToOne(cascade= CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag)
    {
        this.tags.add(tag);

    }
}
