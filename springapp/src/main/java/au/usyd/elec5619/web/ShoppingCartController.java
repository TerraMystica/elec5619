package au.usyd.elec5619.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;
import au.usyd.elec5619.service.ShoppingCartManager;

@Controller
@RequestMapping(value="/shopping/**")
public class ShoppingCartController {
	
	@Resource(name="simpleShoppingCartManager")
	private ShoppingCartManager shoppingCartManager;
	
	@RequestMapping(value="/shoppingCarts")
	public ModelAndView shoppingCart(HttpServletRequest request) {
		
		String now = (new java.util.Date()).toString();
		Map<String,Object> myModel=new HashMap<String, Object>();
		myModel.put("now", now);
		
		myModel.put("shoppingcarts",this.shoppingCartManager.getAllProduct());
		return new ModelAndView("shoppingCarts", "model", myModel);
	}
	
	
	
	@RequestMapping(value="/deleteShoppingCart")
	public String deleteShoppingCart(HttpServletRequest httpServletRequest) {
		shoppingCartManager.deleteProduct(Long.parseLong(httpServletRequest.getParameter("id")));
		return "redirect:/shopping/shoppingCarts.htm";
	}
}
