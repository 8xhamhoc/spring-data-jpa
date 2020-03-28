package com.smd.learning;

import com.smd.learning.entity.Department;
import com.smd.learning.entity.Student;
import com.smd.learning.repository.DepartmentRepository;
import com.smd.learning.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories(basePackages = "com.smd.learning.repository")
@EnableTransactionManagement
@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

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

//        log.debug("Save Department");
//        Department department = new Department("abc");
//        departmentRepository.save(department);
//
//        Student student1 = new Student("Quang");
//        student1.setDepartment(department);
//        Student student2 = new Student("Dung");
//        student2.setDepartment(department);
//        log.debug("Save Student 1");
//        studentRepository.save(student1);
//        log.debug("Save Student 2");
//        studentRepository.save(student2);

        log.info("Finding Department");
        List<Department> departments = departmentRepository.findByName("abc");

        departments.forEach(d -> {

            Iterator it = d.getStudents().entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                log.info("Student name: " + pair.getKey());
            }
        });

        log.info("=============End=============");
    }
}
