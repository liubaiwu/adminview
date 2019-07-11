package me.look.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Controller
public class IndexController {

    @RequestMapping("/tome")
    public String Home()
    {
        return "home";
    }


    @RequestMapping(value = {"/index"})
    public String index(Model model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.addAttribute("test","1112222");
        return "index";
    }
}
