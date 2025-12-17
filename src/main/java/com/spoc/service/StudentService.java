package com.spoc.service;

import com.spoc.entity.Course;
import com.spoc.entity.User;
import java.util.List;

public interface StudentService {
    // 业务功能
    List<Course> getMyCourses(Long studentId);

    // 管理功能
    void addStudent(User student);
    void deleteStudent(Long id);
    void updateStudent(User student);
    List<User> getAllStudents();
    User getStudentById(Long id);
}