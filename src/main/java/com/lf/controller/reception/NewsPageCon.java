package com.lf.controller.reception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class NewsPageCon {
	
	
	@RequestMapping(value="/getNewsAll",method=RequestMethod.GET)
	public ModelAndView getNewsPage(Integer page){
		ModelAndView mv = new ModelAndView();

		
		
		
		
		
		
		
		//总页数
	//	mv.addObject("pagesize",pagesize);
		mv.setViewName("reception/recnews");
		return mv;
	

	}
}
