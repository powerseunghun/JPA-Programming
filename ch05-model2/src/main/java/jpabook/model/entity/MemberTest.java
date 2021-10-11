package jpabook.model.entity;

import javax.persistence.*;

@Entity
public class MemberTest {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	private String username;
	
	public MemberTest() {}
	public MemberTest(String id, String username) {
		this.id = id;
		this.username = username;
	}
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private TeamTest team;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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