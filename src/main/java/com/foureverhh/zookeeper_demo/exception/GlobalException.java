package com.foureverhh.zookeeper_demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = {java.lang.InterruptedException.class})
    public String interruptedExceptionHandler(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(value = {org.apache.zookeeper.KeeperException.class})
    public String keeperExceptionHandler(Exception e){
        return e.getMessage();
    }
}
