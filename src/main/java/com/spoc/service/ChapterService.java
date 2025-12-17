package com.spoc.service;

import com.spoc.entity.Chapter;
import java.util.List;

public interface ChapterService {
    void addChapter(Chapter chapter);
    void deleteChapter(Long id);
    void updateChapter(Chapter chapter);
    List<Chapter> getChaptersByCourseId(Long courseId);
    Chapter getChapterById(Long id);
}