package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//变成了控制器的类controller
public class HelloController {
	@RequestMapping(value="/hello.html")
	public String hello(String username,Model model) {
		System.out.println("使用注解方式annotation输出username的值------->:\t"+username);
		//使用数据模型
		//
		model.addAttribute("username",username);
		System.out.println("使用model方式annotation输出username的值------->:\t"+username);
		
		return "welcome";
	}
	
	//使用ModelAndView方式进行视图的传递
	@RequestMapping(value="hello2.html")
	public ModelAndView hello2(String username) {
		System.out.println("使用ModelAndView对象进行传值------->:\t"+username);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("username",username);
		return mv;
		
		
	}

}
