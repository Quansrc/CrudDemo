package com.quan.crud.util;

import lombok.Data;


/**
 * @Description 统一数据返回类型
 * @ClassName JsonWrite
 * @Author hyf
 * @date 2019.12.01 19:55
 */
@Data
public class JsonWrite {
    //返回状态码
    private String code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

    /**
     * 有返回数据的成功响应
     * @param data
     * @return
     */
    public static JsonWrite SUCCESS(Object data){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setData(data);
        jsonWrite.setCode(CodeDict.SUCCESS.getCode());
        jsonWrite.setMessage(CodeDict.SUCCESS.getDesc());
        return jsonWrite;
    }

    /**
     * 返回数据和自定义信息的成功响应
     * @param data
     * @param message
     * @return
     */
    public static JsonWrite SUCCESS(String message, Object data){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setData(data);
        jsonWrite.setCode(CodeDict.SUCCESS.getCode());
        jsonWrite.setMessage(message);
        return jsonWrite;
    }

    /**
     * 无数据返回的成功响应
     * @return
     */
    public static JsonWrite SUCCESS(){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(CodeDict.SUCCESS.getCode());
        jsonWrite.setMessage(CodeDict.SUCCESS.getDesc());
        return jsonWrite;
    }

    /**
     * 无数据自定义信息的成功响应
     * @param message
     * @return
     */
    public static JsonWrite SUCCESS(String message){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(CodeDict.SUCCESS.getCode());
        jsonWrite.setMessage(message);
        return jsonWrite;
    }

    /**
     * 返回的失败响应
     * @return
     */
    public static JsonWrite FAILED(){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(CodeDict.FAILED.getCode());
        jsonWrite.setMessage(CodeDict.SUCCESS.getDesc());
        return jsonWrite;
    }

    /**
     * 自定义信息的失败响应
     * @param message
     * @return
     */
    public static JsonWrite FAILED(String message){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(CodeDict.FAILED.getCode());
        jsonWrite.setMessage(message);
        return jsonWrite;
    }

    /**
     * 全部自定义响应
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static JsonWrite AUTO(String code, String message, Object data){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(code);
        jsonWrite.setMessage(message);
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 自定义无数据响应
     * @param code
     * @param message
     * @return
     */
    public static JsonWrite AUTO(String code, String message){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(code);
        jsonWrite.setMessage(message);
        return jsonWrite;
    }
    /**
     * 自定义返回信息的系统异常响应
     * @param message
     * @return
     */
    public static JsonWrite ERROR(String message,Object data){
        JsonWrite jsonWrite=new JsonWrite();
        jsonWrite.setCode(CodeDict.EXCEPT.getCode());
        jsonWrite.setMessage(message);
        jsonWrite.setData(data);
        return jsonWrite;
    }
}
