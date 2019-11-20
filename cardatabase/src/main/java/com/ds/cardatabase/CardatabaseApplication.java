package com.ds.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ds.cardatabase.domain.Car;
import com.ds.cardatabase.domain.CarRepository;
import com.ds.cardatabase.domain.Owner;
import com.ds.cardatabase.domain.OwnerRepository;
import com.ds.cardatabase.domain.User;
import com.ds.cardatabase.domain.UserRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class CardatabaseApplication {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("Hello Spring Boot!");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Adding owners to the DB
            Owner owner1 = new Owner("John", "Doe");
            Owner owner2 = new Owner("Brandon", "Stark");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            // Save demo data to db
            carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
            carRepository.save(new Car("Dacia", "Duster", "Black", "DDB-0242", 2018, 20000, owner1));

            // Adding users to the DB
            // username: user, password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }

}
