package com.spoc.service.impl;

import com.spoc.entity.Consultation;
import com.spoc.entity.CourseQA;
import com.spoc.mapper.ConsultationMapper;
import com.spoc.mapper.CourseQAMapper;
import com.spoc.service.InteractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InteractServiceImpl implements InteractService {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Autowired
    private CourseQAMapper courseQAMapper;

    // ================== 咨询管理 (Consultation) ==================

    @Override
    public List<Consultation> getConsultationList() {
        return consultationMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void replyConsultation(Consultation consultation) {
        consultationMapper.reply(consultation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addConsultation(Consultation consultation) {
        consultationMapper.insert(consultation);
    }

    // ================== 课程问答 (CourseQA) ==================

    @Override
    public List<CourseQA> getQAList() {
        return courseQAMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void replyQA(CourseQA qa) {
        courseQAMapper.reply(qa);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addQA(CourseQA qa) {
        courseQAMapper.insert(qa);
    }

    @Override
    public List<CourseQA> getCourseQAList(Long courseId) {
        return courseQAMapper.selectByCourseId(courseId);
    }
}