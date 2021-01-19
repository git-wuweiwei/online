package com.scistor.servicebase.exceptionHandler;


import com.scistor.commonutils.R;
import com.scistor.servicebase.exception.MyByZeroException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2021/1/4 15:42
 */

@ControllerAdvice
@Slf4j
public class myGlobalException {

    @ExceptionHandler(MyByZeroException.class)
    @ResponseBody
    public R myByZeroException(MyByZeroException e){
        return R.error().data("data",e.getCode()).data("message",e.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public R sQLIntegrityConstraintViolationExceptionHandler(SQLException e){
        return R.error().data("data",e.getErrorCode()).data("message","不允许添加相同名字的讲师");
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R handler(Exception e){
        log.error(e.getMessage(),e);
        return R.error().message("ExceptionHandler执行了.....");
    }
}
