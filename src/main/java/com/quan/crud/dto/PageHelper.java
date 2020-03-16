package com.quan.crud.dto;

import lombok.Data;

@Data
public class PageHelper {
    private int page;  //每页
    private int limit;   //页码
}
