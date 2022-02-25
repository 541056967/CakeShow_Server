package com.wonderland.server.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 * */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBean {


    private Long code;
    private String Message;
    private Object obj;

    /**
     * 成功返回对象
     * */
    public static ResBean success(String message){
        return new ResBean(200L, message, null);
    }

    public static ResBean success(String message, Object obj){
        return new ResBean(200L, message, obj);
    }

    /**
     * 失败返回对象
     * */
    public static ResBean error(String message){
        return new ResBean(500L, message, null);
    }

    public static ResBean error(String message, Object obj){
        return new ResBean(500L, message, obj);
    }



}
