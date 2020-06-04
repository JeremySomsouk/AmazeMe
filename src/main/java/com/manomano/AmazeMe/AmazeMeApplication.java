package com.manomano.AmazeMe;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "AmazeMe",
                description = "__I want to play a game. You're in the maze. Find a way out of it.__ <br><br>" +
                        "1. Create a new project using the technologies of your choice.<br>" +
                        "2. Play with this API and along the way you'll find some keys, keep them close to you.<br>" +
                        "3. First, find the wisest of them all.",
                version = "0.42"
        )
)
public class AmazeMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazeMeApplication.class, args);
    }

}
