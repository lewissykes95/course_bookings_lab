package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


//@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }


    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("John", "Edinburgh", 30);
        Customer customer2 = new Customer("Keith", "Glasgow", 40);
        Customer customer3 = new Customer("Mark", "Perth", 31);


        Course course1 = new Course("Python", "Edinburgh", 5);
        Course course2 = new Course("Java", "Glasgow", 4);

        LocalDate date1 = LocalDate.of(2022, 9, 22);
        Booking booking1 = new Booking(date1, course1, customer1);

        LocalDate date2 = LocalDate.of(2022, 9, 22);
        Booking booking2 = new Booking(date2, course2, customer2);

        LocalDate date3 = LocalDate.of(2022, 9, 22);
        Booking booking3 = new Booking(date3, course1, customer3);



        customer1.addBooking(booking1);
        customer2.addBooking(booking2);
        customer3.addBooking(booking3);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);


        course1.addBooking(booking1);
        course1.addBooking(booking3);
        course2.addBooking(booking2);
        courseRepository.save(course1);
        courseRepository.save(course2);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
    }
}
