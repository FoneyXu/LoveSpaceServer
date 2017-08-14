package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoveChlid entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "love_chlid", catalog = "love_space")
public class LoveChlid implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer coupleId;
	private Date createTime;
	private Integer state;

	// Constructors

	/** default constructor */
	public LoveChlid() {
	}

	/** full constructor */
	public LoveChlid(String name, Integer coupleId, Date createTime,
			Integer state) {
		this.name = name;
		this.coupleId = coupleId;
		this.createTime = createTime;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "couple_id")
	public Integer getCoupleId() {
		return this.coupleId;
	}

	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}