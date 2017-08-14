package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoveStory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "love_story", catalog = "love_space")
public class LoveStory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String story;
	private Integer isPhoto;
	private Date createTime;
	private Integer createCustomerId;
	private Integer coupleId;
	private Integer state;

	// Constructors

	/** default constructor */
	public LoveStory() {
	}

	/** full constructor */
	public LoveStory(String story, Integer isPhoto, Date createTime,
			Integer createCustomerId, Integer coupleId, Integer state) {
		this.story = story;
		this.isPhoto = isPhoto;
		this.createTime = createTime;
		this.createCustomerId = createCustomerId;
		this.coupleId = coupleId;
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

	@Column(name = "story", length = 65535)
	public String getStory() {
		return this.story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Column(name = "is_photo")
	public Integer getIsPhoto() {
		return this.isPhoto;
	}

	public void setIsPhoto(Integer isPhoto) {
		this.isPhoto = isPhoto;
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

	@Column(name = "couple_id")
	public Integer getCoupleId() {
		return this.coupleId;
	}

	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}