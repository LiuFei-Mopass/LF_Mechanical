package com.lf.controller.reception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class springmvcDemo {
	
	
	@RequestMapping("/index")
    public String index(){
        return "springmvc-demo";
    }

}
