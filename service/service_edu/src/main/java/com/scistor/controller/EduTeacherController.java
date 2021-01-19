package com.scistor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scistor.commonutils.R;
import com.scistor.entity.EduTeacher;
import com.scistor.entity.vo.TeacherQuery;
import com.scistor.service.EduTeacherService;
import com.scistor.servicebase.exception.MyByZeroException;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-12-31
 */
@Slf4j
@RestController
@RequestMapping("/edu-teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;


    //1. 查询讲师表所有数据
    @ApiOperation(value = "查找所有数据")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public R findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("item", list);
    }

    //2. 分页查询讲师
    @ApiOperation(value = "分页查询讲师对象")
    @GetMapping("/findTeachers/{current}/{limit}")
    public R findPages(@PathVariable Long current, @PathVariable Long limit) {
        //1.分页对象配置
        Page<EduTeacher> page = new Page<>(current, limit);
        eduTeacherService.page(page, null);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }


    //3.条件查询带分页方法
    @ApiOperation(value = "分页带条件查询讲师对象")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable Long current, @PathVariable Long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
//        System.out.println(teacherQuery);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(teacherQuery.getName())) {
            wrapper.like("name", teacherQuery.getName());
        }
        if (!StringUtils.isEmpty(teacherQuery.getLevel())) {
            wrapper.eq("level", teacherQuery.getLevel());
        }
        if (!StringUtils.isEmpty(teacherQuery.getBegin())) {
            wrapper.ge("get_create",teacherQuery.getBegin());
        }
        if (!StringUtils.isEmpty(teacherQuery.getEnd())) {
            wrapper.le("get_modified",teacherQuery.getEnd());
        }

        //根据时间进行排序
        wrapper.orderByDesc("gmt_create");

        eduTeacherService.page(pageTeacher,wrapper);

        return R.ok().data("total", pageTeacher.getTotal()).data("items",pageTeacher.getRecords());
    }


    //4. teacher的添加方法
    @PostMapping("/add")
    public R add(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if ( save ){
            return R.ok().data("添加成功",eduTeacher.getName());
        }else{
            return R.error();
        }
    }

    //5.根据id获取teacher
    @GetMapping("/list/{id}")
    public R getTeacherById(@PathVariable Long id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("查询成功",teacher.getName()).data("item",teacher);
    }


    //6.更新teacher
    @PostMapping("/update")
    public R updateTeacher(@RequestBody EduTeacher teacher){
        System.out.println("12312312");
        boolean b = eduTeacherService.updateById(teacher);
        if(b){
            return R.ok().message("更新成功");
        }else {
            return R.error().message("更新失败");
        }
    }

    //7.删除teacher
    @DeleteMapping("/delete/{id}")
    public R deleteTeacher(@PathVariable Long id){
        boolean b = eduTeacherService.removeById(id);
        if (b){
            return R.ok();
        }else {
            return R.error().data("删除失败",id);
        }
    }
}

