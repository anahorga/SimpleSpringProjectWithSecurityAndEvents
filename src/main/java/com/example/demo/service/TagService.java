package com.example.demo.service;


import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public void save(Tag newTag) {
        tagRepository.save(newTag);
    }
}
