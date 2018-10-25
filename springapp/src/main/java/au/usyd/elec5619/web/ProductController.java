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
		String user=httpServletRequest.getParameter("user");
		Product product=new Product();
		product.setDescription(httpServletRequest.getParameter("description"));
		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		product.setTag(httpServletRequest.getParameter("tag"));
		product.setName(httpServletRequest.getParameter("name"));
		product.setUser(Long.parseLong(user));
		this.productManager.addProduct(product);
		return "redirect:/hello.htm";
	}
}
