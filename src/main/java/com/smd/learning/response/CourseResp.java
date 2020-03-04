package com.smd.learning.response;

import com.smd.learning.entity.Course;

import java.io.Serializable;

public class CourseResp implements Serializable {

    private static final long serialVersionUID = 5607957732422156789L;

    private Course course;

    public CourseResp(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
