package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/rating")
    public ResponseEntity<List<Course>> getCoursesByRating(@RequestParam(name="starRating") int starRating){
        return new ResponseEntity<>(courseRepository.findCourseByStarRating(starRating), HttpStatus.OK);
    }

    @GetMapping("/courses/customers")
    public ResponseEntity<List<Course>> getCourseByCustomerId(@RequestParam(name="id") long id){
        return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerId(id), HttpStatus.OK);
    }

}
