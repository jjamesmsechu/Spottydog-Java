package com.vodaintern.timestamp.Entry;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Configuration
public class EntryConfig {

    @Bean
    CommandLineRunner commandLineRunner2(EntryRepository repository){
        return args -> {
            Entry entry = new Entry(
                    new Date(),
                    LocalTime.of(1,23),
                    LocalTime.of(9,30),
                    0L
            );


            Entry entry2 = new Entry(
                    new Date(),
                    LocalTime.of(1,23),
                    LocalTime.of(9,30)
            );
            repository.saveAll(
                    List.of(entry2,entry)
            );
        };
    }
}
