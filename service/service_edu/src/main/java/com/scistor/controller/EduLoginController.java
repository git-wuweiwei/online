package com.scistor.controller;

import com.scistor.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2021/1/6 9:58
 */

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {


    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R getInfo(){
        return R.ok().data("roles","admin").data("name","admin").data("avatar","https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg");
    }


}
