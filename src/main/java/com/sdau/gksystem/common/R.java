package com.sdau.gksystem.common;

import lombok.Data;

@Data
public class R<T> {

    private Integer status; //编码

    private String message;

    private T rows; //数据

    private long total;

    public static <T> R<T> success(T object, long total) {
        R<T> r = new R<T>();
        r.rows = object;
        r.status = 200;
        r.message = "获取数据成功";
        r.total = total;
        return r;
    }

//    public static pageInfo(){
//
//    }



}
