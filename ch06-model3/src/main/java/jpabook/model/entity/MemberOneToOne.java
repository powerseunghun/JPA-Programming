package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class MemberOneToOne {
	@Id @GeneratedValue
	@Column(name = "MEMBEROTO_ID")
	private Long id;
	private String username;
	
	@OneToOne
	@JoinColumn(name="LOCKEROTO_ID")
	private LockerOneToOne locker;

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

	public LockerOneToOne getLocker() {
		return locker;
	}

	public void setLocker(LockerOneToOne locker) {
		this.locker = locker;
	}
}
