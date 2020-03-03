package com.smd.learning.repository;

import com.smd.learning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByInstructorId(Integer instructorId);
    Optional<Course> findByIdAndInstructorId(Long id, Long instructorId);

}
