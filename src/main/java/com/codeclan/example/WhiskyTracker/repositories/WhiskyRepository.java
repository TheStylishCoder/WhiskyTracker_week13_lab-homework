package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskiesByYear(int year);

    List<Whisky> findWhiskiesByAgeAndDistilleryName(int age, String name);
//
//    List<Whisky> findWhiskiesByDistilleryNameAndDistilleryWhiskiesAge(String name, int age);

    List<Whisky> findWhiskiesByDistilleryRegion(String region);

    List<Whisky> findWhiskiesByAgeGreaterThan(int age);
}
