package com.spoc.service.impl;

import com.spoc.entity.ClassInfo;
import com.spoc.mapper.ClassMapper;
import com.spoc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public void addClass(ClassInfo classInfo) {
        classMapper.insert(classInfo);
    }

    @Override
    @Transactional // 删除班级时，最好把关联关系也清理一下，这里先只删班级表
    public void deleteClass(Long id) {
        classMapper.deleteById(id);
    }

    @Override
    public void updateClass(ClassInfo classInfo) {
        classMapper.update(classInfo);
    }

    @Override
    public List<ClassInfo> getAllClasses() {
        return classMapper.selectAll();
    }

    @Override
    public ClassInfo getClassById(Long id) {
        return classMapper.selectById(id);
    }

    @Override
    public void assignCourse(Long classId, Long courseId) {
        classMapper.assignCourse(classId, courseId);
    }
}