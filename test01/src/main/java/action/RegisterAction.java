package action;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class RegisterAction extends ActionSupport {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public void setUsername(String username) {
		user.setUsername(username);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public void setPassword(String password) {
		user.setPassword(password);
	}


	public void validate() {
		super.clearErrorsAndMessages();
		if("".equals(user.getUsername())) {
			super.addActionError("用户名不能为空！");
		}
		if("".equals(user.getPassword())) {
			super.addActionError("密码不能为空！");
		}
	}
	
	public String execute() {
		if(userService.userRegister(user.getUsername(), user.getPassword())) {
			super.addActionMessage("注册成功！");
		} else {
			super.addActionError("注册失败,该用户名已存在！");
		}
		return "success";
	}
}
