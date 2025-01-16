package com.example.demo.service;


import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    //findAll,save,findById

    public List<Event> findAll()
    {
        return  eventRepository.findAll();
    }
    public void save(Event event)
    {
        eventRepository.save(event);
    }

    public Optional<Event> findById(int id)
    {
        return eventRepository.findById(id);
    }
    public void deleteById(int id)
    {
        eventRepository.deleteById(id);
    }
}
