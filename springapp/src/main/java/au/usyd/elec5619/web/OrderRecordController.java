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

import au.usyd.elec5619.domain.OrderRecord;
import au.usyd.elec5619.domain.ShoppingCart;
import au.usyd.elec5619.service.OrderRecordManager;
import au.usyd.elec5619.service.SimpleOrderRecordManager;


@Controller
@RequestMapping(value="/order/**")
public class OrderRecordController {

	@Resource(name="simpleOrderRecordManager")
	private OrderRecordManager orderRecordManager;
	
	@RequestMapping(value="/getAllOrderRecord")
	public ModelAndView getAllOrderRecord(HttpServletRequest httpServletRequest) {
	
		String now = (new java.util.Date()).toString();
		Map<String,Object> myModel=new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("user", httpServletRequest.getParameter("user"));
		myModel.put("shoppingcarts",this.orderRecordManager.getAllOrderRecords());
		return new ModelAndView("orderRecord", "model", myModel);
		
	}
	
	
	@RequestMapping(value="/addOrderRecord", method=RequestMethod.POST)
	public String addOrderRecord(HttpServletRequest httpServletRequest) {
		/*
		OrderRecord or=new OrderRecord();
		or.setUserId(Long.parseLong(httpServletRequest.getParameter("user").trim()));
		or.setProductId(Long.parseLong(httpServletRequest.getParameter("pid").trim()));
		or.setCount(Integer.parseInt(httpServletRequest.getParameter("pid").trim()));
		or.setDate(Date(httpServletRequest.getParameter("date")));
		
		or.setPayment(httpServletRequest.getParameter("payment").trim());
		or.setStatus(httpServletRequest.getParameter("status").trim());
		or.setShipping(Date(httpServletRequest.getParameter("user").trim()));
		
		or.setPayerdetail(httpServletRequest.getParameter("payerdetail").trim());
		or.setShipdetail(httpServletRequest.getParameter("shipdetail").trim());
		
		
		this.orderRecordManager.addOrderRecord(or);
		*/
		
		return "redirect:/shoppingCart.htm?user="+httpServletRequest.getParameter("user");
		
	}
	
	
	
}
