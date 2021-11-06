package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LockerOneToOneBiDir {
	@Id @GeneratedValue
	@Column(name = "LOCKEROTOBI_ID")
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy = "locker") // MemberOneToOneBiDir.locker 연관관계 주인
	private MemberOneToOneBiDir member;

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

	public MemberOneToOneBiDir getMember() {
		return member;
	}

	public void setMember(MemberOneToOneBiDir member) {
		this.member = member;
	}
}
