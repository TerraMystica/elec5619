package au.usyd.elec5619.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Product")
public class Product implements Serializable{
	@Id
	@GeneratedValue	
	@Column(name="Id")
    private long id;
	@Column(name="description")
	private String description;
	@Column(name="price")
    private Double price;
	@Column(name="tag")
    private String tag;
	@Column(name="name")
    private String name;
	@Column(name="user")
	private long user;
    
    public Product(String name,String tag, Double price, String description) {
    	this.description=description;
    	this.name=name;
    	this.price=price;
    	this.tag=tag;
    
    }
    public Product() {
    
    }
    
    public void setUser(long user) {
    	this.user=user;
    }
  
    public long getUser() {
    	return user;
    }
   
    public void setId(long id) {
    	this.id=id;
    }
    public long getId() {
    	return id;
    }
    public String getDescription() {
    	return description;
    }
    public String getName() {
    	return name;
    }
    public String getTag() {
    	return tag;
    }
    
    public void setDescription(String description) {
    	this.description=description;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
    public void setTag(String tag) {
    	this.tag=tag;
    }
    public Double getPrice() {
    	return price;
    }
    public void setPrice(Double price) {
    	this.price =price;
    }
    public String toString() {
    	StringBuffer buffer =new StringBuffer();
    	buffer.append("Name: "+description+";");
    	buffer.append("Price: "+price);
    	buffer.append("Tag: "+tag);
    	buffer.append("Description: "+description);
    	return buffer.toString();
    }
}
