package com.florence.resources.common.reply;

/**
 * @author Florence
 */
public class ResponseStatHelper {

    public static <T> ResponseStat<T> success(String message) {
        return getResponseStat(message, "200000");
    }

    public static <T> ResponseStat<T> error(String message) {
        return getResponseStat(message, "500000");
    }

    public static <T> ResponseStat<T> getResponseStat(String message, String code) {
        return new ResponseStat(message, code);
    }


    public static <T> ResponseStat<T> success(String message, T data) {
        return getResponseStat(message, "200000", data);
    }

    public static <T> ResponseStat<T> getResponseStat(String message, String code, T data) {
        return new ResponseStat(message, code, data);
    }
}
