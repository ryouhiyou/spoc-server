package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Chapter;
import com.spoc.entity.CourseProgress;
import com.spoc.service.ChapterService;
import com.spoc.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private ProgressService progressService;

    @Autowired
    private ChapterService chapterService;

    // 1. App 上报进度 (心跳包)
    @PostMapping("/progress/upload")
    public Result<String> uploadProgress(@RequestBody CourseProgress progress) {
        if(progress.getStudentId() == null || progress.getChapterId() == null) {
            return Result.error("参数缺失");
        }
        progressService.uploadProgress(progress);
        return Result.success("进度保存成功");
    }

    // 2. App 获取章节详情（包含进度）
    // App 播放视频前调用此接口，获取 url 和上次看到的时间 currentPosition
    @GetMapping("/chapter/detail")
    public Result<Map<String, Object>> getChapterDetail(
            @RequestParam Long studentId,
            @RequestParam Long chapterId) {

        // 获取章节基本信息
        Chapter chapter = chapterService.getChapterById(chapterId); // 需确保 ChapterService 有此方法
        // 获取进度信息
        CourseProgress progress = progressService.getProgress(studentId, chapterId);

        Map<String, Object> map = new HashMap<>();
        map.put("chapter", chapter);
        map.put("progress", progress); // 如果是 null，说明没看过，App 从 0 开始播

        return Result.success(map);
    }
}