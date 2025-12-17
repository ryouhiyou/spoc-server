package com.spoc.mapper;

import com.spoc.entity.CourseProgress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProgressMapper {

    /**
     * 插入或更新进度
     */
    void saveOrUpdateProgress(CourseProgress progress);

    /**
     * 查询某学生某章节的进度
     */
    CourseProgress selectByStudentAndChapter(@Param("studentId") Long studentId, @Param("chapterId") Long chapterId);

    /**
     * 统计某学生某课程完成了多少章节 (用于计算课程总进度)
     */
    int countFinishedChapters(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    List<Map<String, Object>> selectHistoryByStudentId(Long studentId);
}