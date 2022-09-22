package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseId(long id);

    List<Customer> findCustomersByBookingsCourseIdAndTownIgnoreCase(long id, String town);

    List<Customer> findCustomersByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(long id, String town, int age);

}
