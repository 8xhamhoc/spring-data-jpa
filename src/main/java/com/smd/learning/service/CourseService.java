package com.smd.learning.service;

import com.smd.learning.entity.Course;
import com.smd.learning.exception.ResourceNotFoundException;

public interface CourseService {

    Course findByIdAndInstructorId(Integer id, Integer instructorId) throws ResourceNotFoundException;

}
