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
        // ★ 校验增强：确保 studentId, courseId, chapterId 都有
        if(progress.getStudentId() == null || progress.getChapterId() == null) {
            return Result.error("参数缺失");
        }
        progressService.uploadProgress(progress);
        return Result.success("进度保存成功");
    }

    // 2. App 获取章节详情（包含进度）
    @GetMapping("/chapter/detail")
    public Result<Map<String, Object>> getChapterDetail(
            @RequestParam Long studentId,
            @RequestParam Long chapterId) {

        Chapter chapter = chapterService.getChapterById(chapterId);
        CourseProgress progress = progressService.getProgress(studentId, chapterId);

        Map<String, Object> map = new HashMap<>();
        map.put("chapter", chapter);
        map.put("progress", progress);

        return Result.success(map);
    }

    // ★ 3. 新增：App 获取我的学习记录列表 (这就是缺少的那个！)
    // 对应前端 API: /app/progress/list
    @GetMapping("/progress/list")
    public Result<List<Map<String, Object>>> getMyHistory(@RequestParam Long studentId) {
        // 调用 Service 查询列表
        List<Map<String, Object>> list = progressService.getStudentHistory(studentId);
        return Result.success(list);
    }
}