package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Consultation;
import com.spoc.entity.CourseQA;
import com.spoc.mapper.ConsultationMapper;
import com.spoc.mapper.CourseQAMapper;
import com.spoc.service.InteractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/interact")
public class InteractController {

    @Autowired private ConsultationMapper consultationMapper;
    @Autowired private CourseQAMapper courseQAMapper;

    // --- 1. 平台咨询接口 ---
    @GetMapping("/consultation/list")
    public Result<List<Consultation>> listConsultations() {
        return Result.success(consultationMapper.selectAll());
    }

    @PostMapping("/consultation/reply")
    public Result<String> replyConsultation(@RequestBody Consultation consultation) {
        consultationMapper.reply(consultation);
        return Result.success("回复成功");
    }

    // --- 2. 课程问答接口 ---
    @GetMapping("/qa/list")
    public Result<List<CourseQA>> listQAs() {
        return Result.success(courseQAMapper.selectAll());
    }

    @PostMapping("/qa/reply")
    public Result<String> replyQA(@RequestBody CourseQA qa) {
        courseQAMapper.reply(qa);
        return Result.success("答疑成功");
    }

    @Autowired
    private InteractService interactService; // 注入 Service

    // ★ 新增：学生提交咨询
    @PostMapping("/consultation/add")
    public Result<String> addConsultation(@RequestBody Consultation consultation) {
        interactService.addConsultation(consultation); // 调用 Service
        return Result.success("提交成功");
    }

    // ★ 新增：学生提问
    @PostMapping("/qa/add")
    public Result<String> addQA(@RequestBody CourseQA qa) {
        interactService.addQA(qa); // 调用 Service
        return Result.success("提问成功");
    }

    // ★ 新增：学生查看某课程的问答列表
    @GetMapping("/qa/course-list")
    public Result<List<CourseQA>> getCourseQAList(@RequestParam Long courseId) {
        List<CourseQA> list = interactService.getCourseQAList(courseId); // 调用 Service
        return Result.success(list);
    }
}