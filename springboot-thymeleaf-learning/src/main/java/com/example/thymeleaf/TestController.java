package com.example.thymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TestController {


    @GetMapping("/test")
    public String getIndex(ModelMap map){
        map.addAttribute("name","bingbing");
        return "index";
    }
}
