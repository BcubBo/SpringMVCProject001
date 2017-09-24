package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import exception.UserException;
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
	public String addSave(@Validated User user,BindingResult bindingResult,
			MultipartFile attach,HttpServletRequest request) {
		
		String filePath  = request.getSession().getServletContext().getRealPath("/statics/upload");
		//存在操作系统分隔符的问题
		logger.info("上传附件后输出结果为:"+attach.getOriginalFilename()+"\t"+"标签名称为:"+attach.getName());
		if(bindingResult.hasErrors()) {
			return "user/add";
		}else {
			userList.put(user.getId(),user);
			if(!attach.isEmpty()) {
				File saveFile = new File(filePath+File.separator+attach.getOriginalFilename());
				try {
					FileUtils.copyInputStreamToFile(attach.getInputStream(),saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
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
	//RESE风格进行数据的修改
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String udpate(@PathVariable String id,Model model) {
		
		model.addAttribute(userList.get(id));//将user对象放入model中
		return "user/update";
		
	}
	//
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updateSave(@PathVariable String id,@Validated User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "user/update";
		}
		userList.put(id, user);
		return "redirect:/user/list";//只要在mvc中设置了映射，那就会通过servlet的检测来进行相应的跳转
		
	}
	//删除方法
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String id) {
		userList.remove(id);
		return "redirect:/user/list";
	}
/*	//异常抛出和拦截局部异常
	@ExceptionHandler(value= {UserException.class})//局部异常
	public String handlerException(UserException e,HttpServletRequest request) {
		request.setAttribute("e",e);
		return "error";
				
	}
	//登陆方法
*/	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String userName,@RequestParam String password,HttpSession session) {
		
		boolean flag = false;
		
		for(User user:userList.values()){
			if(userName.equals(user.getUserName())&&password.equals(user.getPassword())){
				
				logger.info("登陆成功!");
				session.setAttribute("loginUser",user);
				flag = true;
				break;
				
				
			}
		}
		if(!flag) {
				throw new UserException("用户名密码不正确请重新输入");
			//将异常信息放入session中
		}
		return "redirect:/user/list";
		
	}
	//

	
}
