package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeamTest {
	@Id
	@Column(name="TEAM_ID")
	private String id;
	
	private String name;

	@OneToMany(mappedBy="team")
	private List<MemberTest> members = new ArrayList<MemberTest>();
	
	public TeamTest() {	}
	public TeamTest(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Getter, Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<MemberTest> getMembers() {
		return members;
	}
	public void setMembers(List<MemberTest> members) {
		this.members = members;
	}
}
