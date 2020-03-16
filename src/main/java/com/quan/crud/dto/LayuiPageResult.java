package com.quan.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LayuiPageResult {
    private int code;
    private String msg;
    private int count;
    private Object data;
}

