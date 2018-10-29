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


import au.usyd.elec5619.domain.ShoppingCart;
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
		myModel.put("user", request.getParameter("user"));
		myModel.put("shoppingcarts",this.shoppingCartManager.getAllProduct());
		return new ModelAndView("shoppingCarts", "model", myModel);
	}
	
	
	
	@RequestMapping(value="/deleteShoppingCart")
	public String deleteShoppingCart(HttpServletRequest httpServletRequest) {
		shoppingCartManager.deleteProduct(Long.parseLong(httpServletRequest.getParameter("id")));
		return "redirect:/shopping/shoppingCarts.htm";
	}
	
	@RequestMapping(value="/addShoppingCart")
	public String addShoppingCart(Model uiModel) {
		return "hello";
	}
	
	
	@RequestMapping(value="/addShoppingCart", method=RequestMethod.POST)
	public String addShoppingCart(HttpServletRequest httpServletRequest) {
		
		ShoppingCart sc=new ShoppingCart();
		sc.setUserId(Long.parseLong(httpServletRequest.getParameter("user").trim()));
		sc.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		sc.setCounts(1);
		sc.setProductId(Long.parseLong(httpServletRequest.getParameter("pid").trim()));
		sc.setName(httpServletRequest.getParameter("name"));
		sc.setShippingFee(10);
		
		this.shoppingCartManager.addProduct(sc);
		return "redirect:/hello.htm?user="+httpServletRequest.getParameter("user");
	}
	
	@RequestMapping(value="/updateShoppingCart")
	public String updateShoppingCart(Model uiModel) {
		return "shoppingCarts";
	}
	
	@RequestMapping(value="/updateShoppingCart", method=RequestMethod.POST)
	public String updateShoppingCart(HttpServletRequest httpServletRequest) {
		
		ShoppingCart sc=new ShoppingCart();
		sc.setId(Long.parseLong(httpServletRequest.getParameter("id").trim()));;
		sc.setUserId(Long.parseLong(httpServletRequest.getParameter("user").trim()));
		int count = Integer.parseInt(httpServletRequest.getParameter("count").trim());
		sc.setCounts(count);
		sc.setPrice(count*Double.valueOf(httpServletRequest.getParameter("price")));
		sc.setProductId(Long.parseLong(httpServletRequest.getParameter("pid").trim()));
		sc.setName(httpServletRequest.getParameter("name"));
		sc.setShippingFee(10);
		
		this.shoppingCartManager.updateProduct(sc);
		return "redirect:/hello.htm?user="+httpServletRequest.getParameter("user");
	}
	
	
}
