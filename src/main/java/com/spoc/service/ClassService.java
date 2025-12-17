package com.spoc.service;

import com.spoc.entity.ClassInfo;
import com.spoc.entity.vo.StudentProgressVO;

import java.util.List;

public interface ClassService {
    void addClass(ClassInfo classInfo);
    void deleteClass(Long id);
    void updateClass(ClassInfo classInfo);
    List<ClassInfo> getAllClasses();
    ClassInfo getClassById(Long id);

    // 特殊业务：排课
    void assignCourse(Long classId, Long courseId);

    void addStudent(Long classId, Long studentId);

    List<StudentProgressVO> getClassProgress(Long classId, Long courseId);
}