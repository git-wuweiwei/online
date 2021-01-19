package com.scistor.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2021/1/4 16:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyByZeroException extends RuntimeException {

    private Integer code;

    private String message;

}
