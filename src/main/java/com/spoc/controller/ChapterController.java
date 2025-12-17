package com.spoc.controller;

import com.spoc.common.Result;
import com.spoc.entity.Chapter;
import com.spoc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    // 1. 查列表 (对应 api.getChapterList)
    @GetMapping("/list")
    public Result<List<Chapter>> list(@RequestParam Long courseId) {
        return Result.success(chapterService.getChaptersByCourseId(courseId));
    }

    // 2. 新增 (对应 api.addChapter)
    @PostMapping("/add")
    public Result<String> add(@RequestBody Chapter chapter) {
        chapterService.addChapter(chapter);
        return Result.success("章节添加成功");
    }

    // 3. 删除 (对应 api.deleteChapter)
    @PostMapping("/delete")
    public Result<String> delete(@RequestParam Long id) {
        chapterService.deleteChapter(id);
        return Result.success("章节删除成功");
    }

    // 4. 更新
    @PostMapping("/update")
    public Result<String> update(@RequestBody Chapter chapter) {
        chapterService.updateChapter(chapter);
        return Result.success("章节更新成功");
    }

    // 5. 详情
    @GetMapping("/detail")
    public Result<Chapter> detail(@RequestParam Long id) {
        return Result.success(chapterService.getChapterById(id));
    }
}