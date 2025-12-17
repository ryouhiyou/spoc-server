package com.spoc.mapper;

import com.spoc.entity.CourseQA;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CourseQAMapper {
    // 老师端：查询所有问答
    List<CourseQA> selectAll();

    // 老师端：回复问答
    void reply(CourseQA qa);

    // ★ 新增：学生端提问 (对应XML里的 <insert id="insert">)
    void insert(CourseQA qa);

    // ★ 新增：学生端查看课程问答 (对应XML里的 <select id="selectByCourseId">)
    List<CourseQA> selectByCourseId(@Param("courseId") Long courseId);
}