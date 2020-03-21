package com.smd.learning.controller;

import com.smd.learning.entity.Instructor;
import com.smd.learning.exception.ResourceNotFoundException;
import com.smd.learning.repository.InstructorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    private static final Logger log = LoggerFactory.getLogger(InstructorController.class);

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/instructors")
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Integer instructorId) throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

        instructor.getCourses().forEach(course -> {
            log.info("=== Course title: " + course.getTitle());
        });
        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping("/instructors")
    public Instructor createUser(@Valid @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateUser(@PathVariable(value = "id") Integer instructorId,
                                                 @Valid @RequestBody Instructor userDetails) throws ResourceNotFoundException {
        Instructor user = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        final Instructor updatedUser = instructorRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/instructors/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer instructorId) throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        instructorRepository.delete(instructor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
