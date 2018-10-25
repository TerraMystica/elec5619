package au.usyd.elec5619.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;



public class ProductViewController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());
	private Product product;
	@Resource(name="productManager")
	private ProductManager productManager;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String now = (new java.util.Date()).toString();
		String id=request.getParameter("pid");
		long tureid=Long.parseLong(id);
		product=productManager.getProductById(tureid);
		logger.info("Returning product view with " + now);
		Map<String,Object> myModel=new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("product",this.product);
		
		
		myModel.put("id",id);
	
		return new ModelAndView("productview", "model", myModel);

	}
	
	public void setProduct(Product product) {
		this.product=product;
	}
	public void setProductManager(ProductManager productManager) {
		this.productManager=productManager;
		
	}
}
