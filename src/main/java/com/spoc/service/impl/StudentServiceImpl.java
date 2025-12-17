package com.spoc.service.impl;

import com.spoc.entity.Course;
import com.spoc.entity.User;
import com.spoc.mapper.StudentMapper;
import com.spoc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Course> getMyCourses(Long studentId) {
        return studentMapper.selectCoursesByStudentId(studentId);
    }

    @Override
    public void addStudent(User student) {
        // 默认密码逻辑
        if (student.getPassword() == null) {
            student.setPassword("123456");
        }
        // role 在 SQL 里写死了是 2，这里设置一下只为了对象完整性
        student.setRole(2);
        studentMapper.insert(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void updateStudent(User student) {
        studentMapper.update(student);
    }

    @Override
    public List<User> getAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public User getStudentById(Long id) {
        return studentMapper.selectById(id);
    }
}