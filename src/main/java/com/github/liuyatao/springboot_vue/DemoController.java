package com.github.liuyatao.springboot_vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {


  @RequestMapping(value = "/")
  public String index(){
    return "index";
  }
}
