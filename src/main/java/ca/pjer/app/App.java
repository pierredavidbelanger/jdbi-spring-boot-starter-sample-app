package ca.pjer.app;

import ca.pjer.spring.boot.jdbi.EnableAutoSqlObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoSqlObject
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
