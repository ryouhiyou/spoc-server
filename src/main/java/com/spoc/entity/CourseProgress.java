package com.spoc.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseProgress {
    private Long id;
    private Long studentId;
    private Long courseId;
    private Long chapterId;
    private Integer currentPosition; // 看到第几秒
    private Integer duration;        // 总长度
    private Integer isFinished;      // 1=已完，0=未完
    private LocalDateTime updateTime;
}