package com.florence.resources.utils;

import cn.hutool.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wuyanzhen
 */
public class SessionUtil {


    public static void setSessionAttribute(HttpServletRequest httpRequest,String key,Object value){
        HttpSession session = httpRequest.getSession();
        session.setAttribute(key,value);
    }


    public static Object getSessionAttribute(HttpServletRequest httpRequest,String key){
        HttpSession session = httpRequest.getSession();
        return session.getAttribute(key);
    }
}
