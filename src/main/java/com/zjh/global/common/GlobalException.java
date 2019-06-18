package com.zjh.global.common;

import lombok.Data;

/**
 * @Author: zhangjinhua
 * @Date: 2019/6/17 18:13
 */
@Data
public class GlobalException extends RuntimeException{
    /**
     * 异常编码
     */
    private String errorCode;

    public GlobalException(String message , String errorCode) {
        super(message);
        this.errorCode = errorCode;

    }

}
