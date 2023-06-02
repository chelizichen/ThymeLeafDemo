package com.example.demo.config;

/**
 * 返回状态码 默认 code 0 message : 'OK' DATA:T
 */
public class Ret<T> {
    public int code;
    public String message;
    public T data;

    public Ret(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Ret<T> success(T data){
        return  new Ret<T>(0,"ok",data);
    }
}
