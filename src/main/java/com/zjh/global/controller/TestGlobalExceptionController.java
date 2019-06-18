package com.zjh.global.controller;

import com.zjh.global.common.GlobalException;
import com.zjh.global.emuns.GlobalExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangjinhua
 * @Date: 2019/6/17 17:03
 */
@RestController
@RequestMapping("/")
public class TestGlobalExceptionController {
    @GetMapping("id")
    public String getId(String id) {
        System.out.println(id);
        if (true) {
            throw new GlobalException(GlobalExceptionEnum.RETURN_CODE_100400.getCode(),"请求参数5555555555555555");
        }
        System.out.println("异常捕捉不成功");
        return id;
    }
}
