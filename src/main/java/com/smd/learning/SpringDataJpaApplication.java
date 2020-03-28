package com.smd.learning;

import com.smd.learning.entity.Book;
import com.smd.learning.entity.BoxTurtle;
import com.smd.learning.entity.BoxTurtleId;
import com.smd.learning.repository.BookRepository;
import com.smd.learning.repository.BoxTurtleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.smd.learning.repository")
@EnableTransactionManagement
@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BoxTurtleRepository boxTurtleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
	    log.info("============Start============");

	    /*bookRepository.save(new Book("Deep work"));
	    bookRepository.save(new Book("Harvard at 4 a.m"));
	    bookRepository.save(new Book("Amazon empire"));

	    log.info("============Find all===========");

	    bookRepository.findAll().forEach(x -> log.info("Book name: " + x.getName()));

        log.info("==========Find by name========");

        bookRepository.findByName("Deep work").forEach(x -> log.info("Found: " + x.getName()));*/

//        BoxTurtleId boxTurtleId = new BoxTurtleId("Bad Vilbel", "Roman salad");
//        BoxTurtle boxTurtle = new BoxTurtle(boxTurtleId, "ABC");
//        boxTurtleRepository.save(boxTurtle);

//        List<BoxTurtle> boxTurtles = boxTurtleRepository.findByName("ABC");

//        boxTurtles.forEach(boxTurtle1 -> {
//            log.info(boxTurtle1.toString());
//        });

        log.info("=============End=============");
    }
}
