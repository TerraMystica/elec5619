package au.usyd.elec5619.service;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Product;

import java.util.ArrayList;
import java.util.Iterator;


public class SimpleProductManager implements ProductManager {
	private List<Product> products;
	private List<Product> products2;
	private Product product;
	private Iterator<Product> iterator;
       public List<Product> getProducts(){
    	  return products;
       }
       public void increasePrice(int percentage) {
    	   throw new UnsupportedOperationException();
       }
       
       public void setProducts(List<Product> products) {
    	   this.products=products;
       }
 


	public List<Product> findProductbyName(String name) {
	 
		return null;
		
	}
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Product getProductById(long id) {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getProductsbyUser(long user) {
		// TODO Auto-generated method stub
		return null;
	}





}
