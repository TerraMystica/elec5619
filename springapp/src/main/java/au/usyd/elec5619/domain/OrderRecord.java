package au.usyd.elec5619.domain;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Order")
public class OrderRecord {
	
	@Id
	@GeneratedValue	
	@Column(name="Id")
    private long id;
	
	@Column(name="userid")
    private long userId;
	@Column(name="productid")
    private long productId;
	
	@Column(name="count")
    private long count;
	
	@Column(name="date")
    private Date date;
	@Column(name="status")
    private String status;
	@Column(name="payment")
    private String payment;
    @Column(name="shipping")
    private Date shipping;
    @Column(name="total")
    private double total;
    @Column(name="type")
    private String type;
    @Column(name="payerdetail")
    private String payerdetail;
    @Column(name="shipdetail")
    private String shipdetail;
    

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userid) {
        this.userId = userid;
    }
    
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productid) {
        this.productId = productid;
    }
    
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayment(String payment) {
    	this.payment=payment;
    }
    
    public String getPayment() {
    	return payment;
    }
    
    public Date getShipping() {
        return shipping;
    }

    public void setShipping(Date shipping) {
        this.shipping = shipping;
    }

    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    public String getShipdetail() {
    	return shipdetail;
    }
    
    public void setShipdetail(String shipdetail) {
    	this.shipdetail=shipdetail;
    }
    
    public String getPayerdetail() {
    	return payerdetail;
    }
    
    public void setPayerdetail(String payerdetail) {
    	this.payerdetail=payerdetail;
    }
    
}

