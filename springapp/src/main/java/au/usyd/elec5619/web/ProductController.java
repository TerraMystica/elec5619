package au.usyd.elec5619.web;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;

@Controller
@RequestMapping(value="/product/**")
public class ProductController {
	@Resource(name="productManager")
	private ProductManager productManager;
	@RequestMapping(value="/postProduct")
	public String addProduct(Model uiModel) {
		return "postProduct";
	}
	@RequestMapping(value="/postProduct",method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		
		Product product=new Product();
		product.setUser(Long.parseLong(httpServletRequest.getParameter("user").trim()));
		product.setDescription(httpServletRequest.getParameter("description"));
		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		product.setTag(httpServletRequest.getParameter("tag"));
		product.setName(httpServletRequest.getParameter("name"));
	
		this.productManager.addProduct(product);
		return "redirect:/hello.htm?user="+httpServletRequest.getParameter("user");
	}


}
