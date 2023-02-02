package com.example.jpa.controller;

import com.example.jpa.entity.Study_record;
import com.example.jpa.service.StudyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/study")
public class StudyController {
    private static final Logger logger = LoggerFactory.getLogger(StudyController.class);
    private String prefix = "/study";

    @Autowired
    StudyRecordService studyRecordService;

    @Value("${encrypt.key16}")
    private String strKey162;

    @GetMapping("/list")
    public String list(Model model){
        System.out.println(strKey162);
        List<Study_record> list = studyRecordService.doSelectAll();
        model.addAttribute("list", list);

        return prefix + "/study_list";
    }

    @GetMapping("/insert")
    public String insert(){
        return prefix + "/study_insert";
    }

    @PostMapping("/insert_exe")
    public String insert_exe(@ModelAttribute Study_record study_record){
        studyRecordService.doInsert(study_record);
        return "redirect:/study/list";
        //return prefix + "/list";
    }

    @GetMapping("/modify")
    public String modify(HttpServletRequest request, Model model){
        String key_id = request.getParameter("key_id");

        logger.info("key_id : " + key_id);

        Study_record study_record = studyRecordService.doSelectOne(Integer.parseInt(key_id));
        model.addAttribute("vo_study", study_record);

        return prefix + "/study_modify";
    }

    @PostMapping("/modify_exe")
    public String modify_exe(@ModelAttribute Study_record study_record){
        studyRecordService.doUpdate(study_record);
        return "redirect:/study/list";
        //return prefix + "/list";
    }

    @PostMapping("/delete")
    public String delete(HttpServletRequest request){
        String key_id = request.getParameter("key_id");
        studyRecordService.doDelete(Integer.parseInt(key_id));
        return "redirect:/study/list";
        //return prefix + "/list";
    }
}
