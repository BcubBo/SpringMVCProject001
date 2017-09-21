package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private Map<String,User> userList = new HashMap<String,User>();
	//不建议在此写入成员变量应为为单例模式可能会造成多用户同数据的错误
	Logger logger  = (Logger)LogManager.getLogger();
	
	public UserController() {
		logger.info("初始化");
		userList.put("0",new User("0","bcubbo0","bcubbo0","email@email.com0"));
		userList.put("1",new User("1","bcubbo1","bcubbo1","email@email.com1"));
		userList.put("2",new User("2","bcubbo2","bcubbo2","email@email.com2"));
		userList.put("3",new User("3","bcubbo3","bcubbo3","email@email.com3"));
		logger.info("初始化结束");
		//数据存储
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("userList",userList);
		return "user/userlist";
		
	}
	@RequestMapping(value="/userlist",method=RequestMethod.GET)//以list的方式进行的传递
	public String list(HttpServletRequest request) {
		//使用list方式进行值的传递
		List<User> userList = new ArrayList<User>();
		userList.add(new User("0","bcubbo0","bcubbo0","email@email.com0"));
		userList.add(new User("1","bcubbo1","bcubbo1","email@email.com1"));
		userList.add(new User("2","bcubbo2","bcubbo2","email@email.com2"));
		userList.add(new User("3","bcubbo3","bcubbo3","email@email.com3"));
		request.setAttribute("userList",userList);
		return "user/userlist";
	}
	//使用ModelandView进行传递
	@RequestMapping(value="/list2",method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("使用ModelAndView进行页面的跳转和值的传递");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userlist");//和后缀配合进行页面的跳转
		mv.addObject("userList",userList);
		return mv;
	}
	//
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user")User user) {
		//model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="/addsave",method=RequestMethod.POST)
	public String addSave(@Validated User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "user/add";
		}else {
			userList.put(user.getId(),user);
			
			//return "user/userlist";//服务器端行为
			
			return "redirect:/user/list2";//客户端重新发出请求,以Map的方式进行的传递
		}
		
	}
	
	//REST风格
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id,Model model) {
		model.addAttribute(userList.get(id));//放入的是对象，user对象/获取的为user对象
		return "user/view";
		
	}
	
	
	
}
