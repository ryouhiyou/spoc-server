package com.spoc.mapper;

import com.spoc.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ChapterMapper {
    // 1. 新增
    int insert(Chapter chapter);

    // 2. 删除
    int deleteById(Long id);

    // 3. 更新
    int update(Chapter chapter);

    // 4. 根据课程ID查列表
    List<Chapter> selectByCourseId(@Param("courseId") Long courseId);

    // 5. 根据ID查单个详情
    Chapter selectById(Long id);

    int countByCourseId(Long courseId);
}