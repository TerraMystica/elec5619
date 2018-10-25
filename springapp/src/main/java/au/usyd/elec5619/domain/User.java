package au.usyd.elec5619.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	@GeneratedValue	
	@Column(name="Id")
    private long id;
	@Column(name="accountname")
	private String accountname;
	@Column(name="password")
    private String password;
	@Column(name="type")
    private String type ;
    
    public User(String accountname,String password,String type) {
		this.accountname=accountname;
    	this.password=password;
    	this.type=type;
    
    }
    public User() {
    }
    public void setId(long id) {
    	this.id=id;
    }
    public long getId() {
    	return id;
    }
    public String getPassword() {
    	return password;
    }
    public String getAccountName() {
    	return accountname;
    }
    public String getType() {
    	return type;
    }
    
    public void setPassword(String password) {
    	this.password=password;
    }
    
    public void setAccountName(String accountname) {
    	this.accountname=accountname;
    }
    public void setType(String type) {
    	this.type=type;
    }
    

}
