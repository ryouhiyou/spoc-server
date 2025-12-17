package com.spoc.entity.vo;

import lombok.Data;

@Data
public class StudentProgressVO {
    private Long studentId;
    private String studentName;
    private Integer finishedCount; // 已看完章节数
    private Integer totalCount;    // 总章节数
    private String percent;        // 百分比字符串 (如 "80%")
}