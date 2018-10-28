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
	private long UserId;
	@Resource(name="userManager")
	private UserManager userManager;
	@RequestMapping(value="/login")
	public String login(Model uiModel) {
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest httpServletRequest) {
	
		String name=httpServletRequest.getParameter("AccountName");
		String password=httpServletRequest.getParameter("Password");
	
		if (this.userManager.verify(name,password)== true)
		{   UserId=userManager.getuser().getId();
			return "redirect:/hello.htm?user="+UserId;}
		else {return "redirect:/user/login.htm";}
	}
}
