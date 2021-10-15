package jpabook.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.model.entity.MemberTest;
import jpabook.model.entity.TeamTest;

public class Main {
	static void testSave(EntityManager em) {
		MemberTest member1 = new MemberTest("member1");
		MemberTest member2 = new MemberTest("member2");
		
		TeamTest team1 = new TeamTest("team1");
		team1.getMembers().add(member1);
		team1.getMembers().add(member2);
		
		em.persist(member1);
		em.persist(member2);
		em.persist(team1);
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
