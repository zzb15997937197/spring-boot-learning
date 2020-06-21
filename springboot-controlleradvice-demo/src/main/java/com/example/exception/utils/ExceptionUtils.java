package com.example.exception.utils;


import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionUtils  {

    @ExceptionHandler(value=MyException.class)
    @ResponseBody   // @ResponseBody注解能够将返回数据以json的形式返回
    public ModelAndView exceptionMethod(MyException myException){
        ModelAndView modelAndView = new ModelAndView();
        /*定义视图的名字*/
        modelAndView.setViewName("error");
        modelAndView.addObject("code", myException.getCode());
        modelAndView.addObject("msg", myException.getMsg());
        System.out.println("code=" + myException.getCode() + ";msg=" + myException.getMsg());
        /*返回视图，视图为error.ftl*/
        return modelAndView;
    }

//    @ModelAttribute
//    public void addAttributes(Model model){
//        model.addAttribute("error", "This is Error information");
//        model.addAttribute("exception", "This is Exception information");
//    }

}
