package au.usyd.elec5619.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.UserManager;

@Controller
@RequestMapping(value="/user/**")
public class RegisterController {
	protected final Log logger = LogFactory.getLog(getClass());
	private long UserId;
	static private ModelAndView mav= new ModelAndView("register");
	@Resource(name="userManager")
	private UserManager userManager;
	@RequestMapping(value="/register")
	public ModelAndView register(Model uimodel) {
		return mav;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView regiseter(HttpServletRequest httpServletRequest) {
		String name=httpServletRequest.getParameter("AccountName");
		String password=httpServletRequest.getParameter("Password");
		String cpassword=httpServletRequest.getParameter("ConfirmPassword");
		if(mav.isEmpty()!=true) {mav.clear();}
		if(this.userManager.exist(name)== true)
		{
			mav.addObject("accountnamestatus","Error:Account has existed" );
			}
		else {mav.addObject("accountnamestatus",null );}
		if(password!=cpassword)
		{
			mav.addObject("passwordstatus","Error:Password is unequal" );
			}
		else {mav.addObject("passwordstatus",null);}
		if (this.userManager.exist(name)!= true && password.equals(cpassword))
		{   User u =new User();
			u.setAccountName(name);
			u.setPassword(password);
			u.setType("normaluser");
			this.userManager.addAccount(u);
			mav.setViewName("redirect:/user/login");
			return mav;}
		else {mav.setViewName("register");return mav;}
	}
}
