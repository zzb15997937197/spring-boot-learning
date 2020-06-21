package com.example.exception.utils;


import lombok.Data;

@Data
public class MyException  extends  Exception{

    private String code;
    private String msg;


    public MyException(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
