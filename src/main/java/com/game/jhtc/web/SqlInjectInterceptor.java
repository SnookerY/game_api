package com.game.jhtc.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 防sql注入处理类
 * @author snooker
 *
 */
public class SqlInjectInterceptor implements HandlerInterceptor{  

    @Override  
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)  
            throws Exception {  
        // TODO Auto-generated method stub  

    }  

    @Override  
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)  
            throws Exception {  
        // TODO Auto-generated method stub  

    }  

    @Override  
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {  
        Enumeration<String> names = arg0.getParameterNames();  
        while(names.hasMoreElements()){  
            String name = names.nextElement();  
            String[] values = arg0.getParameterValues(name);  
            for(String value: values){
                //sql注入直接拦截
                if(judgeSQLInject(value.toLowerCase())){  
                	
                    arg1.setContentType("text/html;charset=UTF-8");  
                    JSONObject objData = new JSONObject();   
				    objData.put("ret", 400);    
				    objData.put("data", "[]");  
				    objData.put("msg", "Invalid request param !"); 
				    arg1.getWriter().print(objData);  
                    return false;  
                }
                //跨站xss清理
                clearXss(value);
            }  
        }  
        return true;  
    }  

    /** 
     * 判断参数是否含有攻击串 
     * @param value 
     * @return 
     */  
    public boolean judgeSQLInject(String value){  
        if(value == null || "".equals(value)){  
            return false;  
        }  
        String xssStr = "and|or|select|insert|update|delete|drop|truncate|%20|=|-|--|;|'|%|#|+|,|//|/| |\\|!=|(|)";  
        String[] xssArr = xssStr.split("\\|");  
        for(int i=0;i<xssArr.length;i++){  
            if(value.indexOf(xssArr[i])>-1){  
                return true;  
            }  
        }  
        return false;  
    }

    /**
     * 处理跨站xss字符转义
     *
     * @param value
     * @return
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
                "\"\"");
        value = value.replace("script", "");
        return value;
    }
}