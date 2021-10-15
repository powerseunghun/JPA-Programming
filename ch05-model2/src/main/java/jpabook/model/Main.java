package jpabook.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.model.entity.MemberTest;
import jpabook.model.entity.TeamTest;


/**
 * Created by 1001218 on 15. 4. 5..
 */
public class Main {
	private static void testSave(EntityManager em) {
		// 팀1 저장
		TeamTest team1 = new TeamTest("team1", "팀1");
		em.persist(team1);
		
		// 회원1 저장
		MemberTest member1 = new MemberTest("member1", "회원1");
		member1.setTeam(team1);    // 연관관계 설정 member1 - team1
		em.persist(member1);
		
		// 회원2 저장
		MemberTest member2 = new MemberTest("member2", "회원2");
		member2.setTeam(team1);    // 연관관계 설정 member2 - team1
		em.persist(member2);
	}
	private static void queryLogicJoin(EntityManager em) {
		String jpql = "select m from MemberTest m join m.team t where " + "t.name=:teamName";
		
		List<MemberTest> resultList = em.createQuery(jpql, MemberTest.class).setParameter("teamName", "팀1").getResultList();
		
		System.out.println(resultList.size());
		for (MemberTest m : resultList) {
			System.out.println("[query] member.username=" + m.getUsername());
		}
	}
	private static void updateRelation(EntityManager em) {
		// new team2;
		TeamTest team2 = new TeamTest("team2", "팀2");
		em.persist(team2);
		
		// team2 setting to member1
		MemberTest member = em.find(MemberTest.class, "member1");
		member.setTeam(team2);
	}
	private static void deleteRelation(EntityManager em) {
		MemberTest member1 = em.find(MemberTest.class, "member1");
		member1.setTeam(null);
	}
//	private static void biDirection(EntityManager em) {
//		MemberTest mm = em.find(MemberTest.class, "member1");
//		MemberTest mmm = em.find(MemberTest.class, "member2");
//		TeamTest team = em.find(TeamTest.class, mm.getTeam().getId());
//		System.out.println(mm.getId() + " , " + mm.getUsername() + " , " + mm.getTeam().getId());
//		System.out.println(mmm.getId() + " , " + mmm.getUsername() + " , " + mmm.getTeam().getId());
//		List<MemberTest> members = team.getMembers();
//		System.out.println("findTeam : " + team.getId() + ", teamName : " + team.getName() + " , memberSize : " + team.getMembers().size());
//		
//		for (MemberTest m : members) {
//			System.out.println("member.username = " + m.getUsername());
//		}
//	}
	private static void biDirection(EntityManager em) {
//		MemberTest findMember = em.find(MemberTest.class, "member1");
//		System.out.println("findMember : " + findMember.getId() + ", " + findMember.getUsername() + ", " + findMember.getTeam().getId());
//		List<MemberTest> members = em.find(TeamTest.class, findMember.getTeam().getId()).getMembers();
//		System.out.println("members size : " + members.size());
		TeamTest findTeam = em.find(TeamTest.class, "team1");
		List<MemberTest> members = findTeam.getMembers();
		
		System.out.println("members size : " + members.size());
		for (MemberTest m : members) {
			System.out.println("member.username : " + m.getUsername());
		}
	}
	private static void testSaveNonOwner(EntityManager em) {
		// 회원1 저장
		MemberTest member1 = new MemberTest("member1", "회원1");
		em.persist(member1);
		
		// 회원2 저장
		MemberTest member2 = new MemberTest("member2", "회원2");
		em.persist(member2);
		
		TeamTest team1 = new TeamTest("team1", "팀1");
		// 주인이 아닌 곳만 연관관계 설정
		team1.getMembers().add(member1);
		team1.getMembers().add(member2);
		
		em.persist(team1);
	}
	private static void testPureObject_BiDirection(EntityManager em) {
		TeamTest team1 = new TeamTest("team1", "팀1");
		MemberTest member1 = new MemberTest("member1", "회원1");
		MemberTest member2 = new MemberTest("member2", "회원2");
		
		member1.setTeam(team1);          // 연관관계 설정 member1 -> team1
		team1.getMembers().add(member1); // 연관관계 설정 team1 -> member1
		member2.setTeam(team1);          // 연관관계 설정 member2 -> team1
		team1.getMembers().add(member2); // 연관관계 설정 team1 -> member2
		
		List<MemberTest> members = team1.getMembers();
		System.out.println("members.size = " + members.size());
	}
	public static void testORM_BiDirection(EntityManager em) {
		// 팀1 저장
		TeamTest team1 = new TeamTest("team1", "팀1");
		em.persist(team1);
		
		MemberTest member1 = new MemberTest("member1", "회원1");
		
		// 양방향 연관관계 설정
		member1.setTeam(team1);          // 연관관계 설정 member1 -> team1
		
		// setTeam() 메소드 리팩토링으로 인한 삭제
		// team1.getMembers().add(member1); // 연관관계 설정 team1 -> member1
		em.persist(member1);
		
		MemberTest member2 = new MemberTest("member2", "회원2");
		
		// 양방향 연관관계 설정
		member2.setTeam(team1);          // 연관관계 설정 member2 -> team1
		// setTeam() 메소드 리팩토링으로 인한 삭제
		// team1.getMembers().add(member2); // 연관관계 설정 team1 -> member2
		em.persist(member2);
		
//		List<MemberTest> members = team1.getMembers();
//		System.out.println("member.size = " + members.size());
	}
	private static void testORM_BiDirection_Refactoring(EntityManager em) {
		TeamTest team1 = new TeamTest("team1", "팀1");
		em.persist(team1);

		MemberTest member1 = new MemberTest("member1", "회원1");
		member1.setTeam(team1); // 양방향 설정
		em.persist(member1);

		MemberTest member2 = new MemberTest("member2", "회원2");
		member2.setTeam(team1); // 양방향 설정
		em.persist(member2);
	}
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
            // System.out.println("E");
            // testSave(em);
            // testSaveNonOwner(em);
            // queryLogicJoin(em);
            // updateRelation(em);
            // deleteRelation(em);
            // biDirection(em);
            // testPureObject_BiDirection(em);
//            testORM_BiDirection(em);
            System.out.println("END");
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
