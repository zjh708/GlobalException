package com.zjh.global.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 通用工具类
 */
@Component
public class Utils {


	/**
	 * 响应输出
	 */
	public static void print(Object object) throws IOException {
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			HttpServletResponse response = requestAttributes.getResponse();
			response.addHeader("Cache-Control", "no-cache");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(object);
			out.flush();
			out.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}


	public static Map<String, String> stringToMap(String obj) {
		String[] str = obj.substring(1, obj.length() - 1).split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String m : str) {
			map.put(m.split("=")[0].trim(), m.split("=")[1].trim());
		}
		return map;
	}

}

