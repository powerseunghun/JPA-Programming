package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class TeamTest {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	
	private String name;

	@JoinColumn(name="TEAM_ID")
	List<MemberTest> Members = new ArrayList<MemberTest>();
	
	public TeamTest() {}
	public TeamTest(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<MemberTest> getMembers() {
		return Members;
	}
	
	public void setMembers(List<MemberTest> members) {
		Members = members;
	}
}
