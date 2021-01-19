package com.scistor.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2021/1/4 14:18
 */

@Data
public class TeacherQuery {


    @ApiModelProperty(value = "教师名称，模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔，1 高级讲师，2 首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间")
    private String begin;

    @ApiModelProperty(value = "查询结束时间")
    private String end;



}
