package jpabook.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.model.entity.MemberManyToMany;
import jpabook.model.entity.ProductManyToMany;

public class Main {
	static void ManyToManySave(EntityManager em) {
		ProductManyToMany productA = new ProductManyToMany();
		productA.setId("productA");
		productA.setName("상품A");
		em.persist(productA);
		
		MemberManyToMany member1 = new MemberManyToMany();
		member1.setId("member1");
		member1.setUsername("회원1");
		member1.getProducts().add(productA); // 연관관계 설정
		em.persist(member1);
	}
	static void ManyToManyFind(EntityManager em) {
		MemberManyToMany member = em.find(MemberManyToMany.class, "member1");
		List<ProductManyToMany> products = member.getProducts(); // 객체 그래프 탐색
		for (ProductManyToMany product : products) {
			System.out.println("product.name = " + product.getName());
		}
	}
	static void testSave(EntityManager em) {
//		MemberTest member1 = new MemberTest("member1");
//		MemberTest member2 = new MemberTest("member2");
//		
//		TeamTest team1 = new TeamTest("team1");
//		team1.getMembers().add(member1);
//		team1.getMembers().add(member2);
//		
//		em.persist(member1);
//		em.persist(member2);
//		em.persist(team1);
	}
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
//            testSave(em);
            ManyToManySave(em);
            
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

}
