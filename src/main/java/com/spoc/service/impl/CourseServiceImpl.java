package com.spoc.service.impl;

import com.spoc.entity.Course;
import com.spoc.mapper.CourseMapper;
import com.spoc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseMapper.deleteById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.update(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.selectAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseMapper.selectById(id);
    }
}