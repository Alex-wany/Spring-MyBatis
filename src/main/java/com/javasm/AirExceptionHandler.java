package com.javasm;

import com.javasm.Util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@RestControllerAdvice
public class AirExceptionHandler {

    @ExceptionHandler(Exception.class)
public String handleException(Exception e) {
        return R.error(-1, e.getMessage()).toString();
    }

}
