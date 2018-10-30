package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.domain.ShoppingCart;


@Service(value="simpleShoppingCartManager")
@Transactional
public class SimpleShoppingCartManager implements ShoppingCartManager{

	private SessionFactory sessionFactory;
    private Iterator<Product> iterator;
    private ShoppingCart shoppingCart;
	
    
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
    	this.sessionFactory=sf;
    }
	
	@Override
	public void addProduct(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(shoppingCart);
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = (ShoppingCart) this.sessionFactory.getCurrentSession().get(ShoppingCart.class,id);
		try {
			this.sessionFactory.getCurrentSession().delete(shoppingCart);
		}catch (HibernateException he) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProduct(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		try {
			this.sessionFactory.getCurrentSession().update(shoppingCart);
		}catch (HibernateException he) {
			return false;
		}
		return true;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return (this.sessionFactory).getCurrentSession().createQuery("FROM ShoppingCart").list();
	}

}

