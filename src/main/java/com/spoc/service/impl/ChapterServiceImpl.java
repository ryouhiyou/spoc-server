package com.spoc.service.impl;

import com.spoc.entity.Chapter;
import com.spoc.mapper.ChapterMapper;
import com.spoc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void addChapter(Chapter chapter) {
        // 这里可以加业务逻辑，比如如果没有填排序号，默认为0
        if (chapter.getSort() == null) {
            chapter.setSort(0);
        }
        chapterMapper.insert(chapter);
    }

    @Override
    public void deleteChapter(Long id) {
        chapterMapper.deleteById(id);
    }

    @Override
    public void updateChapter(Chapter chapter) {
        chapterMapper.update(chapter);
    }

    @Override
    public List<Chapter> getChaptersByCourseId(Long courseId) {
        return chapterMapper.selectByCourseId(courseId);
    }

    @Override
    public Chapter getChapterById(Long id) {
        return chapterMapper.selectById(id);
    }
}