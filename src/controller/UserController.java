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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.User;
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private Map<String,User> userList = new HashMap<String,User>();
	Logger logger  = (Logger)LogManager.getLogger();
	
	public UserController() {
		logger.info("初始化");
		userList.put("userObject0",new User("0","bcubbo0","bcubbo0","email@email.com0"));
		userList.put("userObject1",new User("1","bcubbo1","bcubbo1","email@email.com1"));
		userList.put("userObject2",new User("2","bcubbo2","bcubbo2","email@email.com2"));
		userList.put("userObject3",new User("3","bcubbo3","bcubbo3","email@email.com3"));
		logger.info("初始化结束");
		//数据存储
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("userList",userList);
		return "user/userlist";
		
	}
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
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
	@RequestMapping(value="/list2"
}
