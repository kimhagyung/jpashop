package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
	@Id @GeneratedValue
	private Long id;
	
	private String city;
	private String street;
	private String zipcode;
	private DiliverySatus satus;
	
	@OneToOne(mappedBy = "delivery")
	private Order order;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public DiliverySatus getSatus() {
		return satus;
	}
	public void setSatus(DiliverySatus satus) {
		this.satus = satus;
	}
	
	
}
