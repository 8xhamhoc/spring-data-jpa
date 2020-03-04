package com.smd.learning.controller;

import com.smd.learning.entity.Course;
import com.smd.learning.exception.ResourceNotFoundException;
import com.smd.learning.repository.CourseRepository;
import com.smd.learning.repository.InstructorRepository;
import com.smd.learning.response.CourseResp;
import com.smd.learning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping("/instructors/{instructorId}/courses")
    public List<Course> getCoursesByInstructor(@PathVariable(value = "instructorId") Integer instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }

    @PostMapping("/instructors/{instructorId}/courses")
    public Course createCourse(@PathVariable(value = "instructorId") Integer instructorId,
                               @Valid @RequestBody Course course) throws ResourceNotFoundException {
        return instructorRepository.findById(instructorId).map(instructor -> {
            course.setInstructor(instructor);
            return courseRepository.save(course);
        }).orElseThrow(() -> new ResourceNotFoundException("instructor not found"));
    }

    @PutMapping("/instructors/{instructorId}/courses/{courseId}")
    public Course updateCourse(@PathVariable(value = "instructorId") Integer instructorId,
                               @PathVariable(value = "courseId") Long courseId,
                               @Valid @RequestBody Course courseRequest) throws ResourceNotFoundException {

        if (!instructorRepository.existsById(instructorId)) {
            throw new ResourceNotFoundException("instructorId not found");
        }

        return courseRepository.findById(courseId).map(course -> {
            course.setTitle(courseRequest.getTitle());
            return courseRepository.save(course);
        }).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
    }

    @DeleteMapping("/instructors/{instructorId}/courses/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable(value = "instructorId") Integer instructorId,
                                          @PathVariable(value = "courseId") Integer courseId) throws ResourceNotFoundException {
        return courseRepository.findByIdAndInstructorId(courseId, instructorId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId + " and instructorId " + instructorId));
    }

    @GetMapping("/instructors/{instructorId}/courses/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable(value = "instructorId") Integer instructorId,
                                       @PathVariable(value = "courseId") Integer courseId) throws ResourceNotFoundException {
        Course course = courseService.findByIdAndInstructorId(courseId, instructorId);
        if (course == null) {
            new ResourceNotFoundException("Course not found with id " + courseId + " and instructorId " + instructorId);
        }
        return new ResponseEntity(new CourseResp(course), HttpStatus.OK);
    }

}
