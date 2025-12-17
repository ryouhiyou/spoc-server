package com.spoc.mapper;

import com.spoc.entity.Consultation;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ConsultationMapper {
    // 查询所有咨询 (关联查学生名)
    List<Consultation> selectAll();

    // 回复咨询
    void reply(Consultation consultation);
}