package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Course;
import com.spoc.entity.User;
import com.spoc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ================== 1. 学生端业务接口 (Portal) ==================

    // 查我的课程
    @GetMapping("/my-courses")
    public Result<List<Course>> getMyCourses(@RequestParam Long studentId) {
        return Result.success(studentService.getMyCourses(studentId));
    }

    // ================== 2. 教师端管理接口 (CRUD) ==================

    // 列表 (Read List)
    @GetMapping("/list")
    public Result<List<User>> list() {
        return Result.success(studentService.getAllStudents());
    }

    // 新增 (Create)
    @PostMapping("/add")
    public Result<String> addStudent(@RequestBody User student) {
        studentService.addStudent(student);
        return Result.success("学生录入成功，初始密码: 123456");
    }

    // 删除 (Delete)
    @PostMapping("/delete")
    public Result<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return Result.success("删除成功");
    }

    // 更新 (Update)
    @PostMapping("/update")
    public Result<String> updateStudent(@RequestBody User student) {
        studentService.updateStudent(student);
        return Result.success("更新成功");
    }
}