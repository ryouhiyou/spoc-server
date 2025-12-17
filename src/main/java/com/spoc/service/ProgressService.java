package com.spoc.service;

import com.spoc.entity.CourseProgress;

import java.util.List;
import java.util.Map;

public interface ProgressService {
    void uploadProgress(CourseProgress progress);
    CourseProgress getProgress(Long studentId, Long chapterId);
    List<Map<String, Object>> getStudentHistory(Long studentId);
}