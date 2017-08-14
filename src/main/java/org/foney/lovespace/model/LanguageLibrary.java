package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LanguageLibrary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "language_library", catalog = "love_space")
public class LanguageLibrary implements java.io.Serializable {

	// Fields

	private Integer id;
	private String requestContent;
	private String responseContent;
	private Integer coupleId;
	private Date createTime;
	private Integer createCustomerId;
	private Integer state;

	// Constructors

	/** default constructor */
	public LanguageLibrary() {
	}

	/** full constructor */
	public LanguageLibrary(String requestContent, String responseContent,
			Integer coupleId, Date createTime, Integer createCustomerId,
			Integer state) {
		this.requestContent = requestContent;
		this.responseContent = responseContent;
		this.coupleId = coupleId;
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

	@Column(name = "request_content", length = 65535)
	public String getRequestContent() {
		return this.requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	@Column(name = "response_content", length = 65535)
	public String getResponseContent() {
		return this.responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
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

}