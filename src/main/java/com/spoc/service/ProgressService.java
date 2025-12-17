package com.spoc.service;

import com.spoc.entity.CourseProgress;

public interface ProgressService {
    void uploadProgress(CourseProgress progress);
    CourseProgress getProgress(Long studentId, Long chapterId);
}