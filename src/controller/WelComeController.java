package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelComeController extends AbstractController{
//等同于struts2 action中的execute方法
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("Welcome SpringMVC");
		return new ModelAndView("welcome");
	}
	

}
