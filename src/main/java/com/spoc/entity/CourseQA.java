package com.spoc.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseQA {
    private Long id;
    private Long courseId;
    private String courseName;  // 冗余字段
    private Long studentId;
    private String studentName; // 冗余字段
    private String title;
    private String content;
    private String reply;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime replyTime;
}