package com.spoc.mapper;

import com.spoc.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseMapper {
    // 1. 新增
    int insert(Course course);

    // 2. 查列表
    List<Course> selectAll();

    // 3. 【新增】根据ID删除
    int deleteById(Long id);

    // 4. 【新增】更新课程信息
    int update(Course course);

    // 5. 【新增】根据ID查单个 (用于回显或详情)
    Course selectById(Long id);
}