package com.spoc.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Consultation {
    private Long id;
    private Long studentId;
    private String studentName; // 冗余字段，SQL关联查询用
    private String content;
    private String reply;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime replyTime;
}