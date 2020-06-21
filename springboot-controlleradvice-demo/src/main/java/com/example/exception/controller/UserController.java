package com.example.exception.controller;


import com.example.exception.utils.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {


    @GetMapping("/api/test")
    public void testControllerAdvice()  throws  Exception {
        int a=1;
//        try {
//            int c=a/0;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        throw new Exception("发生错误!");
    }



    /*该方法用于响应http://localhost:8080/errorPage请求*/
    @RequestMapping("/errorPage")
    /*注意此地的errorMethod方法千万不要定义成error，因为Spring boot框架中默认有error方法，如果此地写成error方法，与Spring boot的内部的方法冲突*/
    /*这个“error”模型属性是在后面@ModelAttribute注解标注的addAttributes方法中放进去的*/
    public String errorMethod(@ModelAttribute("error") String error) throws Exception{
        System.out.println("-----error-------" + error);
        throw new MyException("500","服务器出现错误!");

    }

}
