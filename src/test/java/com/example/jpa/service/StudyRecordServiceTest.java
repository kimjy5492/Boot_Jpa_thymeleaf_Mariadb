package com.example.jpa.service;

import com.example.jpa.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService studyRecordService;

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .study_day("2023-01-31")
                .contents("Insert Test")
                .reg_day(LocalDateTime.now())
                .build();

        studyRecordService.doInsert(study_record);
    }

    @Test
    void doUpdate() {
        Study_record study_record = studyRecordService.doSelectOne(2);
        study_record.setContents("대박!!");
        study_record.setStudy_day("2023-01-31");

        studyRecordService.doUpdate(study_record);
    }

    @Test
    void doUpdate2() {
        studyRecordService.doUpdate(2);
    }

    @Test
    @Transactional
    void doDelete() {
        studyRecordService.doDelete(2);
    }

    @Test
    void doSelectAll() {
    }

    @Test
    void doSelectOne() {
    }

}