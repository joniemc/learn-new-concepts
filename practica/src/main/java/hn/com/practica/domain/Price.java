package hn.com.practica.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRICES")
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRICE_ID")
	private long priceId;
	
	@Column(name="BRAND_ID")
	private long brandId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="PRICE_LIST")
	private int priceList;
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="PRIORITY")
	private int priority;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="CURR")
	private String curr;
	
	public Price(){}
	
	public Price(long brandId, Date startDate, Date endDate, int priceList, 
			long productId, int priority, double price, String curr){
		this.brandId=brandId;
		this.startDate=startDate;
		this.endDate=endDate;
		this.priceList=priceList;
		this.productId=productId;
		this.priority=priority;
		this.price=price;
		this.curr=curr;
	}
	
	
	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
}
