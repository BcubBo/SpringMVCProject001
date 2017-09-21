package pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private String id;
	private String userName;
	private String password;
	private String email;
	
	public User() {}
	
	
	public User(String id,String userName,String password,String email) {
		System.out.println("构造方法启动");
		this.id = id;
		this.userName=userName;
		this.password=password;
		this.email=email;
		System.out.println("构造方法结束");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@NotEmpty(message="用户名不能为空")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Size(min=4,max=10,message="密码长度必须是4-10位之间")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Email(message="邮箱格式不正确")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
