package com.quan.crud.util;

/**
 *
 */
public enum CodeDict {
    Code("404","资源找不到了");

    private String code;
    private String Message;

    CodeDict(String code, String message) {
        this.code = code;
        Message = message;
    }
}
