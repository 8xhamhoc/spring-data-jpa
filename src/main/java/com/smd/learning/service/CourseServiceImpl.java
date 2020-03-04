package com.smd.learning.service;

import com.smd.learning.entity.Course;
import com.smd.learning.exception.ResourceNotFoundException;
import com.smd.learning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findByIdAndInstructorId(Integer id, Integer instructorId) throws ResourceNotFoundException {
        Optional<Course> courseOptional = courseRepository.findByIdAndInstructorId(id, instructorId);
        Course course = courseOptional.get();

        if (course.getInstructor() != null) {
            System.out.println("Instructor email: " + course.getInstructor().getEmail());
        }

        return course;
    }

}
