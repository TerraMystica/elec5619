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

import au.usyd.elec5619.service.ProductManager;

public class DeleteController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource(name="productManager")
	private ProductManager productManager;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user=request.getParameter("user");

		Map<String,Object> myModel=new HashMap<String, Object>();
        long user1=Long.parseLong(user);
		myModel.put("user", user);
		myModel.put("products",this.productManager.getProductsbyUser(user1));
		return new ModelAndView("deleteProduct", "model", myModel);

	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager=productManager;
		
	}
}