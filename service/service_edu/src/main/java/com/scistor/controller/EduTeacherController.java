package com.scistor.controller;


import com.scistor.entity.EduTeacher;
import com.scistor.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-12-31
 */
@RestController
@RequestMapping("/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;


    //1. 查询讲师表所有数据
    @RequestMapping("/findAll")
    public List<EduTeacher> findAll(){
        return eduTeacherService.list(null);
    }

}

