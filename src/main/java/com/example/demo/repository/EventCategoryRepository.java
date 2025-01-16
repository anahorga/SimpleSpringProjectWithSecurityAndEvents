package com.example.demo.repository;


import com.example.demo.model.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory,Integer> {
}
