package au.usyd.elec5619.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.classic.Session;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import au.usyd.elec5619.domain.Product;
@Service(value="productManager")
@Transactional
public class DatabaseProductManager implements ProductManager {
	private List<Product> products;
	private List<Product> products2;
    private SessionFactory sessionFactory;
    private Iterator<Product> iterator;
    private Product product;
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
    	this.sessionFactory=sf;
    }
	@Override
	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getProducts() {
		return (this.sessionFactory).getCurrentSession().createQuery("FROM Product").list();
	}

	@Override
	public void setProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		
	}

	@Override
	public void deleteProduct(long id) {
		Session currentSession=this.sessionFactory.getCurrentSession();
		Product product=(Product)currentSession.get(Product.class, id);
		currentSession.delete(product);
	}

	@Override
	public Product getProductById(long id) {
		Session currentSession=this.sessionFactory.getCurrentSession();
		Product product=(Product)currentSession.get(Product.class, id);
	    return product;
		
	}



	@Override
	public List<Product> findProductbyName(String name) {
		products=(this.sessionFactory).getCurrentSession().createQuery("FROM Product").list();
		iterator=products.iterator();
		products2=new ArrayList();
	    while(iterator.hasNext()){
	    	product=(Product) iterator.next();
	    	if(product.getName().contains(name)) {
	    		products2.add(product);
	    	}
	    }
		
		return products2;
	}
	

}
