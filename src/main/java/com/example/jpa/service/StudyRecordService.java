package com.example.jpa.service;

import com.example.jpa.entity.Study_record;
import com.example.jpa.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepo studyRecordRepo;

    public List<Study_record> doSelectAll(){
        return studyRecordRepo.findAll();
    }

    public Study_record doSelectOne(int key_id){
        return studyRecordRepo.findById(key_id).get();
    }

    public void doUpdate(Study_record study_record){
        studyRecordRepo.save(study_record);
    }

    public void doUpdate(int key_id){
        Study_record study_record = studyRecordRepo.findById(key_id).get();
        study_record.setStudy_day("2023-02-01");
        study_record.setContents("오우!!");

        studyRecordRepo.save(study_record);
    }

    public void doInsert(Study_record study_record){
        studyRecordRepo.save(study_record);
    }

    public void doDelete(int key_id){
        studyRecordRepo.deleteById(key_id);
    }
}
