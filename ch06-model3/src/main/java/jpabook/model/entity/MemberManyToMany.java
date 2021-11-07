package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class MemberManyToMany {
	@Id @GeneratedValue
	private String id;
	
	private String username;
	
	/**
	 * @JoinTable.name: 연결 테이블 지정, MEMBER_PRODUCT 테이블 선택
	 * @JoinTable.joinColumns: 현재 방향인 회원과 매핑할 조인 컬럼 정보 지정
	 * @JoinTable.inverseJoinColumns: 반대 방향인 상품과 매핑할 조인 컬럼 정보 지정
	 */
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	@JoinTable(name = "MEMBER_PRODUCT", 
			   joinColumns=@JoinColumn(name = "MEMBERMTM_ID"), 
			   inverseJoinColumns = @JoinColumn(name = "PRODUCTMTM_ID"))
	private List<ProductManyToMany> products = new ArrayList<ProductManyToMany>();

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

	public List<ProductManyToMany> getProducts() {
		return products;
	}

	public void setProducts(List<ProductManyToMany> products) {
		this.products = products;
	}
}
