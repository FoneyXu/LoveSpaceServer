package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Couple entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "couple", catalog = "love_space")
public class Couple implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer fromCustomerId;
	private Integer toCustomerId;
	private Date inviteTime;
	private Date replyTime;
	private Date leftTime;
	private Integer state;

	// Constructors

	/** default constructor */
	public Couple() {
	}

	/** full constructor */
	public Couple(String name, Integer fromCustomerId, Integer toCustomerId,
			Date inviteTime, Date replyTime,Date leftTime, Integer state) {
		this.name = name;
		this.fromCustomerId = fromCustomerId;
		this.toCustomerId = toCustomerId;
		this.inviteTime = inviteTime;
		this.replyTime = replyTime;
		this.leftTime = leftTime;
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

	@Column(name = "from_customer_id")
	public Integer getFromCustomerId() {
		return this.fromCustomerId;
	}

	public void setFromCustomerId(Integer fromCustomerId) {
		this.fromCustomerId = fromCustomerId;
	}

	@Column(name = "to_customer_id")
	public Integer getToCustomerId() {
		return this.toCustomerId;
	}

	public void setToCustomerId(Integer toCustomerId) {
		this.toCustomerId = toCustomerId;
	}

	@Column(name = "invite_time", length = 19)
	public Date getInviteTime() {
		return this.inviteTime;
	}

	public void setInviteTime(Date inviteTime) {
		this.inviteTime = inviteTime;
	}

	@Column(name = "reply_time", length = 19)
	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "left_time")
	public Date getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Date leftTime) {
		this.leftTime = leftTime;
	}

}