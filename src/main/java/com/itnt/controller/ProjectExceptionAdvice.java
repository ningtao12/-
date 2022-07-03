package com.itnt.controller;


import com.itnt.exception.BusinessException;
import com.itnt.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        e.printStackTrace();
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试");
    }
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        e.printStackTrace();
        return new Result(e.getCode(),null,e.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        e.printStackTrace();
        return new Result(e.getCode(),null,e.getMessage());
    }
}
