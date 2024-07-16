package com.vodaintern.timestamp.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            Users user1 = new Users(
                    "deronaaron",
                    "tokyo",
                    1L
            );


            Users user2 = new Users(
                    "user2",
                    "password",
                    2L
            );
            repository.saveAll(
                    List.of(user1,user2)
            );
        };
    }
}