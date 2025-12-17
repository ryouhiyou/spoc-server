package com.spoc.service;

import com.spoc.entity.Course;
import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(Long id);
    void updateCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
}