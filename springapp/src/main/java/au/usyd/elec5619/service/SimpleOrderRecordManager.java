package au.usyd.elec5619.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.OrderRecord;
import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.domain.ShoppingCart;


@Service(value="simpleOrderRecordManager")
@Transactional
public class SimpleOrderRecordManager implements OrderRecordManager{

	private SessionFactory sessionFactory;
    private Iterator<Product> iterator;

	
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
    	this.sessionFactory=sf;
    }
	@Override
	public void addOrderRecord(OrderRecord OrderRecord) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(OrderRecord);
		
	}

	@Override
	public boolean deleteOrderRecord(long id) {
		// TODO Auto-generated method stub
		OrderRecord orderRecord = (OrderRecord) this.sessionFactory.getCurrentSession().get(OrderRecord.class,id);
		try {
			this.sessionFactory.getCurrentSession().delete(orderRecord);
		}catch (HibernateException he) {
			return false;
		}
		return true;
	}

	@Override
	public List<OrderRecord> getShoppingRecords(int userId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<OrderRecord> getAllOrderRecords() {
		// TODO Auto-generated method stub
		return (this.sessionFactory).getCurrentSession().createQuery("FROM orderrecord").list();
	}

}
