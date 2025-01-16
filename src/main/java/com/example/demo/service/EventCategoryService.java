package com.example.demo.service;


import com.example.demo.model.EventCategory;
import com.example.demo.repository.EventCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    public List<EventCategory> findAll()
    {
        return eventCategoryRepository.findAll();
    }

    public void save(EventCategory newCategory) {

        eventCategoryRepository.save(newCategory);
    }

    public Optional<EventCategory> findById(Integer categoryId) {

        return eventCategoryRepository.findById(categoryId);
    }
}
