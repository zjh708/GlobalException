package com.zjh.global.entity;


import com.zjh.global.emuns.GlobalExceptionEnum;

import java.io.Serializable;

/**
 * 返回消息实体类
 * */
public class Massage implements Serializable{

	private boolean success;//是否成功
	private String errorCode;//错误代码
	private String msg;//返回信息
	private Object data="";//封装返回数据

	public Massage() {}

	public Massage(GlobalExceptionEnum responseCodeEnum, Object object){
		this.errorCode = responseCodeEnum.getCode();
		this.data = object;
		this.msg = responseCodeEnum.getMsg();
		if(this.errorCode.equals(GlobalExceptionEnum.RETURN_CODE_100200.getCode())){
			this.success = true;
		} else {
			this.success = false;
		}
	}

	public Massage(GlobalExceptionEnum responseCodeEnum){
		this.errorCode = responseCodeEnum.getCode();
		this.msg = responseCodeEnum.getMsg();
		if(this.errorCode.equals(GlobalExceptionEnum.RETURN_CODE_100200.getCode())){
			this.success = true;
		} else {
			this.success = false;
		}
	}


	public Massage(String errorCode, String msg){
		this.errorCode = errorCode;
		this.msg = msg;
		if(this.errorCode.equals(GlobalExceptionEnum.RETURN_CODE_100200.getCode())){
			this.success = true;
		} else {
			this.success = false;
		}
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}