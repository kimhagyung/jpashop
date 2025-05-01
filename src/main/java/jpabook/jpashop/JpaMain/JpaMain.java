package jpabook.jpashop.JpaMain;

import java.lang.reflect.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //디비 연결 됨 
		EntityManager em =emf.createEntityManager();
		//jpa에서는 트랜잭션이 매우 중요함 무조건 넣어줘야된다고 함 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			 
			Book book=new Book();
			book.setName("JPA");
			book.setAuthor("김영한");
			
			em.persist(book);
			
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
