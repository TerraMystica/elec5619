package au.usyd.elec5619.service;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import au.usyd.elec5619.domain.Product;
import junit.framework.TestCase;
public class SimpleProductManagerTest extends TestCase {
        private SimpleProductManager productManager;
        private List<Product> products;
        private static int PRODUCT_COUNT=2;
        private static Double CHAIR_PRICE=new Double(20.50);
        private static String CHAIR_DESCRIPTION="Chair";
        private static String TABLE_DESCRIPTION="Table";
        private static Double TABLE_PRICE=new Double(150.10);
        protected void setUp() throws Exception{
        	productManager = new SimpleProductManager();
        	products=new ArrayList<Product>();
        	Product product=new Product();
        	product.setDescription("Chair");
        	product.setPrice(CHAIR_PRICE);
        	products.add(product);
        	product=new Product();
        	product.setDescription("Table");
        	product.setPrice(TABLE_PRICE);
        	products.add(product);
        	productManager.setProducts(products);;
        			
        	
        }
        public void testGetProductsWithNoproducts() {
        	productManager=new SimpleProductManager();
        	assertNull(productManager.getProducts());
        }
        public void testGetProducts() {
        	List<Product> products=productManager.getProducts();
        	assertNotNull(products);
        	
        	assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
        	
        	Product product =products.get(0);
        	assertEquals(CHAIR_DESCRIPTION,product.getDescription());
        	assertEquals(CHAIR_PRICE,product.getPrice());
        	 product =products.get(1);
        	assertEquals(TABLE_DESCRIPTION,product.getDescription());
        	assertEquals(TABLE_PRICE,product.getPrice());
        }
}
