package com.spoc.mapper;

import com.spoc.entity.CourseQA;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseQAMapper {
    // 查询所有问答 (关联查课程名和学生名)
    List<CourseQA> selectAll();

    // 回复问答
    void reply(CourseQA qa);
}