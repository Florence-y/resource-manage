package com.florence.resources.common.reply;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Florence
 */
@Data
@NoArgsConstructor
public class ResponseStat<T> {
    private String message;
    private T data;
    private String code;

    public ResponseStat(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ResponseStat(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
