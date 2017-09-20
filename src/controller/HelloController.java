package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//变成了控制器的类controller
public class HelloController {
	@RequestMapping(value="/hello.html")
	public String hello() {
		System.out.println("使用注解方式annotation");
		
		return "welcome";
	}

}
