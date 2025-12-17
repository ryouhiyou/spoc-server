package com.spoc.mapper;

import com.spoc.entity.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ClassMapper {

    // 1. 新增
    int insert(ClassInfo classInfo);

    // 2. 查列表
    List<ClassInfo> selectAll();

    // 3. 【新增】删除班级
    int deleteById(Long id);

    // 4. 【新增】更新班级信息
    int update(ClassInfo classInfo);

    // 5. 【新增】查单个班级详情
    ClassInfo selectById(Long id);

    // 6. 给班级排课 (保持不变)
    int assignCourse(@Param("classId") Long classId, @Param("courseId") Long courseId);

    void addStudentToClass(@Param("classId") Long classId, @Param("studentId") Long studentId);
}