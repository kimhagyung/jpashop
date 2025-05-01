package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order  extends BaseEntity{

	
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	//@Column(name="MEMBER_ID") 이제 필요없음 
	//private Long memberId; //누가 주문했는지 알게하기 위해 
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;

	@OneToOne
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delivery;
	
	private LocalDateTime orderDate;
	
	
	@Enumerated(EnumType.STRING) //순서를 위해 꼭 ! string으로 
	private OrderStatus status;
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems= new ArrayList<>();

	//ㅇ연관관계 편의 메소두ㅡ)((양방향관계일떄)
	public void addOrderItem(OrderItem orderItem) { 
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
