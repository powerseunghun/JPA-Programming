package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MemberOneToOneBirDirFKInTargetTable {
	@Id @GeneratedValue
	@Column(name = "MEMBEROTOFIT_ID")
	private Long id;
	
	private String username;
	
	@OneToOne(mappedBy = "member")
	private LockerOneToOneBiDirFKInTargetTable locker;

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

	public LockerOneToOneBiDirFKInTargetTable getLocker() {
		return locker;
	}

	public void setLocker(LockerOneToOneBiDirFKInTargetTable locker) {
		this.locker = locker;
	}
}
