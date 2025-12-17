package com.spoc.service;

import com.spoc.entity.Consultation;
import com.spoc.entity.CourseQA;
import java.util.List;

public interface InteractService {

    // ================== 咨询管理 (Consultation) ==================

    /**
     * [老师端] 查询所有咨询列表
     */
    List<Consultation> getConsultationList();

    /**
     * [老师端] 回复咨询
     */
    void replyConsultation(Consultation consultation);

    /**
     * [学生端] 提交新的咨询
     */
    void addConsultation(Consultation consultation);


    // ================== 课程问答 (CourseQA) ==================

    /**
     * [老师端] 查询所有问答列表 (用于后台管理)
     */
    List<CourseQA> getQAList();

    /**
     * [老师端] 回复问答
     */
    void replyQA(CourseQA qa);

    /**
     * [学生端] 提交新的提问
     */
    void addQA(CourseQA qa);

    /**
     * [学生端] 查询指定课程的问答列表
     * @param courseId 课程ID
     */
    List<CourseQA> getCourseQAList(Long courseId);
}