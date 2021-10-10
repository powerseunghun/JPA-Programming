package jpabook.start;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
//@SequenceGenerator(
//		name="BOARD_SEQ_GENERATOR", 
//		sequenceName="BOARD_SEQ", // 매핑할 데이터베이스 시퀀스 이름
//		initialValue=-1, allocationSize=1)
@TableGenerator(
		name="BOARD_SEQ_GENERATOR", 
		table="MY_SEQUENCES", 
		pkColumnValue="BOARD_SEQ", allocationSize = 1)
public class Board {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
//					generator="BOARD_SEQ_GENERATOR")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
//					generator="BOARD_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue
	// @GeneratedValue.strategy이 기본값은 AUTO 이므로 strategy 속성을 생략해도 결과는 같다.
	private Long id;
	
	private static void logic(EntityManager em) {
		Board board = new Board();
		em.persist(board);
		System.out.println("board.id = " + board.getId());
	}
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
