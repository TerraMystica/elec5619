package au.usyd.elec5619.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Spring;

import org.hibernate.classic.Session;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.domain.User;
@Service(value="userManager")
@Transactional
public class UserManager  {
	private List<User> users1;
	private List<User> users2;
    private SessionFactory sessionFactory;
    public User u;
    private Iterator<User> iterator;
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
    	this.sessionFactory=sf;
    }

    public User getuser() {
    	return u;
    }
	public void addAccount(User user) {
		this.sessionFactory.getCurrentSession().save(user);
		
	}


	public List<User> getAccoutList() {
		return (this.sessionFactory).getCurrentSession().createQuery("FROM User").list();

		
	}
	public Boolean verify(String name,String password) {
		Boolean check=false;
		users1=(this.sessionFactory).getCurrentSession().createQuery("FROM User").list();
		iterator=users1.iterator();
		users2=new ArrayList();
	    while(iterator.hasNext()){
	    	u=(User) iterator.next();
	    	if(u.getAccountName().equals(name)&&u.getPassword().equals(password) ){
	    		check=true;
	    		break;
	    	}
	    }
		
		return check;
	}
	//
	public Boolean exist(String name) {
		Boolean check=false;
		users1=(this.sessionFactory).getCurrentSession().createQuery("FROM User").list();
		iterator=users1.iterator();
		users2=new ArrayList();
	    while(iterator.hasNext()){
	    	u=(User) iterator.next();
	    	if(u.getAccountName().equals(name)){
	    		check=true;
	    		break;
	    	
	    	}
	    }
		
		return check;
	}

}
