package com.spoc.service.impl;

import com.spoc.entity.CourseProgress;
import com.spoc.mapper.ProgressMapper;
import com.spoc.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressMapper progressMapper;

    @Override
    public void uploadProgress(CourseProgress progress) {
        // 简单业务逻辑：如果看到 90% 以上，自动标记为已完成
        if (progress.getDuration() != null && progress.getDuration() > 0) {
            double ratio = (double) progress.getCurrentPosition() / progress.getDuration();
            if (ratio > 0.9) {
                progress.setIsFinished(1);
            }
        }
        progressMapper.saveOrUpdateProgress(progress);
    }

    @Override
    public CourseProgress getProgress(Long studentId, Long chapterId) {
        return progressMapper.selectByStudentAndChapter(studentId, chapterId);
    }
}