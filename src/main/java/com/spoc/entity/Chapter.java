package com.spoc.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Chapter {
    /**
     * 章节ID
     */
    private Long id;

    /**
     * 所属课程ID
     */
    private Long courseId;

    /**
     * 章节标题
     */
    private String title;

    /**
     * 视频链接 (mp4地址)
     */
    private String videoUrl;

    /**
     * 排序号 (前端可能没传，数据库默认为0)
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}