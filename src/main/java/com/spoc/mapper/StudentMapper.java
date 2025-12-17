package com.spoc.mapper;

import com.spoc.entity.Course;
import com.spoc.entity.User; // 记得导入 User
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface StudentMapper {

    // --- 原有业务：学生查课 ---
    List<Course> selectCoursesByStudentId(@Param("studentId") Long studentId);

    // --- 新增管理功能：CRUD ---

    // 1. 新增学生 (其实就是往 sys_user 插数据，且 role=2)
    int insert(User student);

    // 2. 删除学生
    int deleteById(Long id);

    // 3. 更新学生信息
    int update(User student);

    // 4. 查询所有学生列表 (只查 role=2 的)
    List<User> selectAllStudents();

    // 5. 根据ID查学生
    User selectById(Long id);
}