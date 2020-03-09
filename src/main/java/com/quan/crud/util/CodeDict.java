package com.quan.crud.util;

/**
 * @Description
 * @ClassName CodeDice
 * @Author hyf
 * @date 2019.12.01 20:03
 */
public enum CodeDict {
    NOAUTH("100","您暂无权限操作！"),
    SUCCESS("200","操作成功！"),
    FAILED("300","操作失败！"),
    LOGIN_NEED("400","您还未登录！"),
    EXCEPT("500","系统出现了意外！"),
    NOT_PERMISSION_REQUEST("-1","不允许的操作！");

    private String code;

    private String desc;

    private CodeDict(String code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }
}