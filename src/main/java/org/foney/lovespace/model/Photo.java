package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "love_space")
public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String photoUrl;
	private Integer objId;
	private Integer photoOrder;
	private Date createTime;
	private Integer createCustomerId;
	private Integer state;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(String name, String photoUrl, Integer objId,
			Integer photoOrder, Date createTime, Integer createCustomerId,
			Integer state) {
		this.name = name;
		this.photoUrl = photoUrl;
		this.objId = objId;
		this.photoOrder = photoOrder;
		this.createTime = createTime;
		this.createCustomerId = createCustomerId;
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

	@Column(name = "photo_url", length = 100)
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Column(name = "obj_id")
	public Integer getObjId() {
		return this.objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	@Column(name = "photo_order")
	public Integer getPhotoOrder() {
		return this.photoOrder;
	}

	public void setPhotoOrder(Integer photoOrder) {
		this.photoOrder = photoOrder;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_customer_id")
	public Integer getCreateCustomerId() {
		return this.createCustomerId;
	}

	public void setCreateCustomerId(Integer createCustomerId) {
		this.createCustomerId = createCustomerId;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}