package au.usyd.elec5619.service;
import java.io.Serializable;
import java.util.List;
import au.usyd.elec5619.domain.Product;
public interface ProductManager extends Serializable{
	
     public void increasePrice(int percentage);
  
     public List<Product> getProducts();
     public void setProducts(List<Product> products); 	  
     public void addProduct(Product product);
     public void deleteProduct(long id);
     public Product getProductById(long id);

	
	 public List<Product> findProductbyName(String name);
}
