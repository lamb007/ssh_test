package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class LoginAction extends ActionSupport implements SessionAware {
	private UserService userService;


	 private Map session;
    public void setSession(Map session) {
        this.session = session;
    }

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
		if(userService.loginVerify(user.getUsername(), user.getPassword())){
			User user = new User();
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			session.put("user", user);
			return "success";
		} else {
			super.addActionError("登录失败！");
			return INPUT;
		}
	}
}
