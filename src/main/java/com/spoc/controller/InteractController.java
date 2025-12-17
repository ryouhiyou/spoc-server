package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Consultation;
import com.spoc.entity.CourseQA;
import com.spoc.mapper.ConsultationMapper;
import com.spoc.mapper.CourseQAMapper;
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
}