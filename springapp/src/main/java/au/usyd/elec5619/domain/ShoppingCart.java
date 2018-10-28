package au.usyd.elec5619.domain;
import javax.persistence.*;

@Entity
@Table(name="Shoppingcart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue	
	@Column(name="Id")
    private long id;
	@Column(name="userid")
    private int userId;
	@Column(name="productid")
    private int productId;
	@Column(name="name")
    private String name;
    @Column(name="counts")
    private int counts;
    @Column(name="price")
    private double price;
    @Column(name="shippingFee")
    private double shippingFee;
    

    public long getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
    	this.name=name;
    }
    
    public String getName() {
    	return name;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }

    
    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
    
    
    public double getShippingFee() {
    	return shippingFee;
    }
    
    public void setShippingFee(double shippingFee) {
    	this.shippingFee=shippingFee;
    }
    
   
}

