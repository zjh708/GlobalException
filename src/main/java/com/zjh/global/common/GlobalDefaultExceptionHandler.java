package com.zjh.global.common;

import com.alibaba.fastjson.JSONObject;
import com.zjh.global.emuns.GlobalExceptionEnum;
import com.zjh.global.entity.Massage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 全局异常
 * @Author: zhangjinhua
 * @Date: 2019/6/17 18:00
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception exception) {
        JSONObject json = null;
        System.err.println("捕捉异常成功");
        if (exception instanceof GlobalException) {
            logger.error("全局异常", exception);
            json = (JSONObject) JSONObject.toJSON( new Massage( ((GlobalException) exception).getErrorCode(), exception.getMessage()));
        }else if (exception instanceof  Exception){
            logger.error("未知异常", exception);
            json = (JSONObject) JSONObject.toJSON( new Massage( GlobalExceptionEnum.RETURN_CODE_100500, exception.getMessage()));

        }
        try {
            Utils.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
