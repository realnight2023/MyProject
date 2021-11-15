package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductImages")
public class Picture {
	@Id
	private int pid;
    private String path;
    String productName;    
	String description;
    public Picture() {}
    public Picture(int id, String n ,String p , String d) {
    	pid = id;
    	path=p;
    	productName=n;
    	description=d;
    }
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String getProductName() {
		return productName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}