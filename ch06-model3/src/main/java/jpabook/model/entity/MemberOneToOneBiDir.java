package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MemberOneToOneBiDir {
	@Id @GeneratedValue
	@Column(name="MEMBEROTOBI_ID")
	private Long id;
	
	private String username;
	
	@OneToOne
	@JoinColumn(name="LOCKEROTOBI_ID")
	private LockerOneToOneBiDir locker;

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

	public LockerOneToOneBiDir getLocker() {
		return locker;
	}

	public void setLocker(LockerOneToOneBiDir locker) {
		this.locker = locker;
	}
}
