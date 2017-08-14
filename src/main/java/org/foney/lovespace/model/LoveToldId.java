package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LoveToldId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class LoveToldId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String content;
	private Date toldTime;
	private Integer frequency;
	private Integer coupleId;
	private Date createTime;
	private Integer createCustomerId;
	private Integer state;

	// Constructors

	/** default constructor */
	public LoveToldId() {
	}

	/** full constructor */
	public LoveToldId(Integer id, String name, String content, Date toldTime,
			Integer frequency, Integer coupleId, Date createTime,
			Integer createCustomerId, Integer state) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.toldTime = toldTime;
		this.frequency = frequency;
		this.coupleId = coupleId;
		this.createTime = createTime;
		this.createCustomerId = createCustomerId;
		this.state = state;
	}

	// Property accessors

	@Column(name = "id")
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

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "told_time", length = 19)
	public Date getToldTime() {
		return this.toldTime;
	}

	public void setToldTime(Date toldTime) {
		this.toldTime = toldTime;
	}

	@Column(name = "frequency")
	public Integer getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoveToldId))
			return false;
		LoveToldId castOther = (LoveToldId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())))
				&& ((this.getToldTime() == castOther.getToldTime()) || (this
						.getToldTime() != null
						&& castOther.getToldTime() != null && this
						.getToldTime().equals(castOther.getToldTime())))
				&& ((this.getFrequency() == castOther.getFrequency()) || (this
						.getFrequency() != null
						&& castOther.getFrequency() != null && this
						.getFrequency().equals(castOther.getFrequency())))
				&& ((this.getCoupleId() == castOther.getCoupleId()) || (this
						.getCoupleId() != null
						&& castOther.getCoupleId() != null && this
						.getCoupleId().equals(castOther.getCoupleId())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())))
				&& ((this.getCreateCustomerId() == castOther
						.getCreateCustomerId()) || (this.getCreateCustomerId() != null
						&& castOther.getCreateCustomerId() != null && this
						.getCreateCustomerId().equals(
								castOther.getCreateCustomerId())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result
				+ (getToldTime() == null ? 0 : this.getToldTime().hashCode());
		result = 37 * result
				+ (getFrequency() == null ? 0 : this.getFrequency().hashCode());
		result = 37 * result
				+ (getCoupleId() == null ? 0 : this.getCoupleId().hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		result = 37
				* result
				+ (getCreateCustomerId() == null ? 0 : this
						.getCreateCustomerId().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		return result;
	}

}