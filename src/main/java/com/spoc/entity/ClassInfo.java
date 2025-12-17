package com.spoc.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ClassInfo {
    private Long id;            // 对应 id
    private String className;   // 对应 class_name
    private Long teacherId;     // 对应 teacher_id
    private LocalDateTime createTime;
}