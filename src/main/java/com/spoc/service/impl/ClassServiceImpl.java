package com.spoc.service.impl;

import com.spoc.entity.ClassInfo;
import com.spoc.entity.User;
import com.spoc.entity.vo.StudentProgressVO;
import com.spoc.mapper.ChapterMapper;
import com.spoc.mapper.ClassMapper;
import com.spoc.mapper.ProgressMapper;
import com.spoc.mapper.StudentMapper;
import com.spoc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public void addStudent(Long classId, Long studentId) {
        classMapper.addStudentToClass(classId, studentId);
    }

    // 注入需要的 Mapper
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private ProgressMapper progressMapper; // 刚才写的进度Mapper

    @Override
    public List<StudentProgressVO> getClassProgress(Long classId, Long courseId) {
        // 1. 查出班级里所有学生
        List<User> students = studentMapper.selectByClassId(classId);
        // 2. 查出课程总章节数
        int totalChapters = chapterMapper.countByCourseId(courseId);

        List<StudentProgressVO> result = new ArrayList<>();

        // 3. 遍历计算每个人的进度
        for (User student : students) {
            StudentProgressVO vo = new StudentProgressVO();
            vo.setStudentId(student.getId());
            vo.setStudentName(student.getRealName());
            vo.setTotalCount(totalChapters);

            if (totalChapters == 0) {
                vo.setFinishedCount(0);
                vo.setPercent("0%");
            } else {
                // 调用之前写好的 countFinishedChapters
                int finished = progressMapper.countFinishedChapters(student.getId(), courseId);
                vo.setFinishedCount(finished);

                // 计算百分比 (整数运算需转double)
                int p = (int) ((double) finished / totalChapters * 100);
                vo.setPercent(p + "%");
            }
            result.add(vo);
        }
        return result;
    }
}