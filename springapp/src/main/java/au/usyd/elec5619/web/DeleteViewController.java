package au.usyd.elec5619.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;

@Controller
@RequestMapping(value="/product/**")
public class DeleteViewController {
	protected final Log logger = LogFactory.getLog(getClass());
	private Product product;
	@Resource(name="productManager")
	private ProductManager productManager;

	
	@RequestMapping("/deleteview")
	public ModelAndView deletelist(HttpServletRequest request)  {
		
		String now = (new java.util.Date()).toString();
		String id=request.getParameter("pid");
		long tureid=Long.parseLong(id);
		product=productManager.getProductById(tureid);
		logger.info("Returning product view with " + now);
		Map<String,Object> myModel=new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("product",this.product);
		
		
		myModel.put("id",id);
	
		return new ModelAndView("deleteview", "model", myModel);

	}
	
	@RequestMapping(value="/deleteview",method=RequestMethod.POST)
	public ModelAndView deleteProduct(HttpServletRequest httpServletRequest) {
		
		String id =httpServletRequest.getParameter("pid");
		long trueid=Long.parseLong(id);
	
		this.productManager.deleteProduct(trueid);
		
		ModelAndView mav=new ModelAndView("redirect:/hello.htm?user="+httpServletRequest.getParameter("user"));
		return mav;
	}
	public void setProduct(Product product) {
		this.product=product;
	}
	public void setProductManager(ProductManager productManager) {
		this.productManager=productManager;
		
	}
	
	
	
}
