package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.ClassInfo;
import com.spoc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService; // 注入 Service

    // 1. 创建班级 (增)
    @PostMapping("/add")
    public Result<String> addClass(@RequestBody ClassInfo classInfo) {
        classService.addClass(classInfo);
        return Result.success("班级创建成功，ID: " + classInfo.getId());
    }

    // 2. 删除班级 (删)
    @PostMapping("/delete")
    public Result<String> deleteClass(@RequestParam Long id) {
        classService.deleteClass(id);
        return Result.success("班级删除成功");
    }

    // 3. 修改班级 (改)
    @PostMapping("/update")
    public Result<String> updateClass(@RequestBody ClassInfo classInfo) {
        classService.updateClass(classInfo);
        return Result.success("班级信息更新成功");
    }

    // 4. 班级列表 (查)
    @GetMapping("/list")
    public Result<List<ClassInfo>> list() {
        return Result.success(classService.getAllClasses());
    }

    // 5. 班级详情 (查)
    @GetMapping("/detail")
    public Result<ClassInfo> detail(@RequestParam Long id) {
        return Result.success(classService.getClassById(id));
    }

    // 6. 给班级排课 (特殊业务)
    @PostMapping("/assign")
    public Result<String> assignCourse(@RequestBody Map<String, Long> params) {
        Long classId = params.get("classId");
        Long courseId = params.get("courseId");

        if (classId == null || courseId == null) {
            return Result.error("参数错误：classId 或 courseId 不能为空");
        }

        classService.assignCourse(classId, courseId);
        return Result.success("排课成功");
    }

    @PostMapping("/add-student")
    public Result<String> addStudent(@RequestBody Map<String, Long> params) {
        Long classId = params.get("classId");
        Long studentId = params.get("studentId");

        if (classId == null || studentId == null) {
            return Result.error("参数错误：classId 或 studentId 不能为空");
        }

        classService.addStudent(classId, studentId);
        return Result.success("学生添加成功");
    }

    @GetMapping("/progress")
    public Result<List<com.spoc.entity.vo.StudentProgressVO>> getClassProgress(
            @RequestParam Long classId,
            @RequestParam Long courseId) {
        return Result.success(classService.getClassProgress(classId, courseId));
    }
}