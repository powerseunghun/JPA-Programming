package jpabook.start;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="MEMBER", uniqueConstraints= {@UniqueConstraint(
		name = "NAME_AGE_UNIQUE",
		columnNames = {"NAME", "AGE"}
)})
public class Member {
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="NAME", nullable=false, length=10)
	private String username;
	
	private Integer age;
	
	// == 추가 ==
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;
	
	// Getter, Setter
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public Integer getAge() { return age; }
	public void setAge(Integer age) { this.age = age; }
	
	public RoleType getRoleType() { return roleType; }
	public void setRoleType(RoleType roleType) { this.roleType = roleType; }
	
	public Date getCreatedDate() { return createDate; }
	public void setCreatedDate(Date createdDate) { this.createDate = createdDate; }
	
	public Date getLastModiFiedDate() { return lastModifiedDate; }
	public void setLastModifiedDate(Date lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
}

