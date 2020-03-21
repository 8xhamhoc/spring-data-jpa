package com.smd.learning;

import com.smd.learning.entity.DateTime;
import com.smd.learning.repository.DateTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@EnableJpaRepositories(basePackages = "com.smd.learning.repository")
@EnableTransactionManagement
@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

    @Autowired
    private DateTimeRepository dateTimeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("============Start============");

	    /*bookRepository.save(new Book("Deep work"));
        bookRepository.save(new Book("Harvard at 4 a.m"));
	    bookRepository.save(new Book("Amazon empire"));

	    log.info("============Find all=========");

	    bookRepository.findAll().forEach(x -> log.info("Book name: " + x.getName()));

        log.info("==========Find by name========");

        bookRepository.findByName("Deep work").forEach(x -> log.info("Found: " + x.getName()));*/

        /*Calendar calendarDate = Calendar.getInstance(
                TimeZone.getTimeZone("UTC"));
        calendarDate.set(Calendar.YEAR, 2017);
        calendarDate.set(Calendar.MONTH, 10);
        calendarDate.set(Calendar.DAY_OF_MONTH, 15);

        dateTimeRepository.save(new DateTime(
                new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"),
                new SimpleDateFormat("HH:mm:ss").parse("15:30:14"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                        .parse("2017-11-15 15:30:14.332"),
                calendarDate, calendarDate, "Hello"
        ));*/

        List<DateTime> dateTimes = dateTimeRepository.findByValue("Hello");

        dateTimes.forEach(dateTime -> {
            log.info(dateTime.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
            log.info("Calendar timestamp time: " + dateTime.getCalendarTimestamp().getTime());
            log.info("Calendar timestamp: " + sdf.format(dateTime.getCalendarTimestamp().getTime()));
        });

        log.info("=============End=============");
    }
}
