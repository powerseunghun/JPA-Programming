package jpabook.model.entity;

import javax.persistence.*;

@Entity
public class MemberTest {
	
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private TeamTest team;
	public MemberTest() {}
	public MemberTest(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TeamTest getTeam() {
		return team;
	}

	public void setTeam(TeamTest team) {
		this.team = team;
	}
}
