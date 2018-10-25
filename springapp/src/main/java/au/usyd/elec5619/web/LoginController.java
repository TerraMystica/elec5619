package au.usyd.elec5619.web;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.UserManager;

@Controller
@RequestMapping(value="/user/**")
public class LoginController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Resource(name="userManager")
	private UserManager userManager;
	@RequestMapping(value="/login")
	public String login(Model uiModel) {
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest httpServletRequest) {
		User u=new User();
		u.setAccountName(httpServletRequest.getParameter("AccountName"));
		u.setPassword(httpServletRequest.getParameter("Password"));
		u.setType(httpServletRequest.getParameter("Type"));
		if (this.userManager.verify(u.getAccountName(),u.getPassword())== true)
		{  return "redirect:/hello.htm?user=${u.getId()}";}
		else {return "redirect:/user/login.htm";}
	}
}
