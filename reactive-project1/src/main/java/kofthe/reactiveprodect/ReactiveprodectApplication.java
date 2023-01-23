package kofthe.reactiveprodect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class ReactiveprodectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveprodectApplication.class, args);
    }

}
