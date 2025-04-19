package jpabook.jpashop.JpaMain;

import java.lang.reflect.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Order;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //디비 연결 됨 
		EntityManager em =emf.createEntityManager();
		//jpa에서는 트랜잭션이 매우 중요함 무조건 넣어줘야된다고 함 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			
			Order order = em.find(Order.class, 1L);
			Long memberId = order.getMemberId(); //이렇게 하면 안됨  
			
			Member member=em.find(Member.class, memberId);
			
			//Member findMEmber= order.getMember();
			
			 tx.commit();
		} catch (Exception e) {
			tx.rollback(); 
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
