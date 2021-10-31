package com.florence.resources.common.reply;

/**
 * @author Florence
 */
public class ResponseStatHelper {

    public static  <T> ResponseStat<T> success(String message){
        return getResponseStat(message,"200000");
    }

    public static <T> ResponseStat<T> error(String message) {
        return getResponseStat(message,"500000");
    }

    public static <T> ResponseStat<T> getResponseStat(String message,String code){
        return new ResponseStat(message,code);
    }
}
