package com.manomano.AmazeMe.configuration;

import com.manomano.AmazeMe.repository.LocationsRepository;
import com.manomano.AmazeMe.repository.UsersRepository;
import com.manomano.AmazeMe.repository.model.Location;
import com.manomano.AmazeMe.repository.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InMemoryConfiguration {

    @Bean
    CommandLineRunner initDatabase(UsersRepository usersRepository, LocationsRepository locationsRepository) {
        return args -> {
            User user1 = User.builder().username("Bilbo Baggins").advice("Sorry! I don’t want any adventures, thank you.").job("Burglar").build();
            User user2 = User.builder().username("Gandalf The White").advice("You shall not pass !").job("Wizard").build();
            User user3 = User.builder().username("Frodo Baggins").advice("There is no real going back.").job("Thief").build();
            User user4 = User.builder().username("Grima Wormtongue").advice("Oh, but you are alone.").job("Advisor").build();

            usersRepository.save(user1);
            usersRepository.save(user2);
            usersRepository.save(user3);
            usersRepository.save(user4);
            locationsRepository.save(Location.builder().spotId("mountain").build());
            locationsRepository.save(Location.builder().spotId("forest").build());
            locationsRepository.save(Location.builder().spotId("lake").build());
            locationsRepository.save(Location.builder().spotId("beach").build());
        };
    }
}
