package com.spoc.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Course {
    private Long id;            // 对应 id
    private String courseName;  // 对应 course_name
    private String description; // 对应 description
    private String cover;       // 对应 cover
    private Long teacherId;     // 对应 teacher_id
    private LocalDateTime createTime; // 对应 create_time
}