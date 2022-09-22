package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/course")
    public ResponseEntity<List<Customer>> getCustomersByCourseId(@RequestParam (name="id") long id){
        return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseId(id), HttpStatus.OK);
    }

    @GetMapping("/customers/town")
    public ResponseEntity<List<Customer>> getCustomerByCourseAndTown(@RequestParam (name="id") long id, @RequestParam (name="town") String town) {
        return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseIdAndTownIgnoreCase(id, town), HttpStatus.OK);
    }

    @GetMapping("/customers/town/age")
    public ResponseEntity<List<Customer>> getCustomerByCourseAndTownAndAgeGreaterThan(@RequestParam (name="id") long id, @RequestParam (name="town") String town, @RequestParam(name="age") int age){
        return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(id, town, age), HttpStatus.OK);
    }

}
