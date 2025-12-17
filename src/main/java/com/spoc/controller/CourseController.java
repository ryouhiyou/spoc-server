package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Course;
import com.spoc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService; // 注入 Service，不再是 Mapper

    // 1. 增 (Create)
    @PostMapping("/add")
    public Result<String> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return Result.success("发布成功");
    }

    // 2. 删 (Delete)
    @PostMapping("/delete")
    public Result<String> deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return Result.success("删除成功");
    }

    // 3. 改 (Update)
    @PostMapping("/update")
    public Result<String> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return Result.success("修改成功");
    }

    // 4. 查列表 (Read List)
    @GetMapping("/list")
    public Result<List<Course>> list() {
        return Result.success(courseService.getAllCourses());
    }

    // 5. 查详情 (Read One) - 方便编辑时回显
    @GetMapping("/detail")
    public Result<Course> detail(@RequestParam Long id) {
        return Result.success(courseService.getCourseById(id));
    }
}