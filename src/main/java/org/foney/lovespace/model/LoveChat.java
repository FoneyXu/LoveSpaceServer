package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoveChat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "love_chat", catalog = "love_space")
public class LoveChat implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String photoUrl;
	private String radioUrl;
	private Integer chatType;
	private Integer fromCustomerId;
	private Integer toCustomerId;
	private Integer coupleId;
	private Date createTime;
	private Integer createCustomerId;
	private Integer createType;
	private Integer state;

	// Constructors

	/** default constructor */
	public LoveChat() {
	}

	/** full constructor */
	public LoveChat(String content, String photoUrl,String radioUrl, Integer chatType,Integer fromCustomerId,
			Integer toCustomerId,Integer coupleId, Date createTime, Integer createCustomerId,
			Integer createType, Integer state) {
		this.content = content;
		this.photoUrl = photoUrl;
		this.radioUrl = radioUrl;
		this.chatType = chatType;
		this.fromCustomerId = fromCustomerId;
		this.toCustomerId = toCustomerId;
		this.coupleId = coupleId;
		this.createTime = createTime;
		this.createCustomerId = createCustomerId;
		this.createType = createType;
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

	@Column(name = "content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "photo_url", length = 100)
	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Column(name = "radio_url", length = 100)
	public String getRadioUrl() {
		return this.radioUrl;
	}

	public void setRadioUrl(String radioUrl) {
		this.radioUrl = radioUrl;
	}

	@Column(name = "chat_type")
	public Integer getChatType() {
		return this.chatType;
	}

	public void setChatType(Integer chatType) {
		this.chatType = chatType;
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

	@Column(name = "create_type")
	public Integer getCreateType() {
		return this.createType;
	}

	public void setCreateType(Integer createType) {
		this.createType = createType;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@Column(name = "from_customer_id")
	public Integer getFromCustomerId() {
		return fromCustomerId;
	}

	public void setFromCustomerId(Integer fromCustomerId) {
		this.fromCustomerId = fromCustomerId;
	}

	@Column(name = "to_customer_id")
	public Integer getToCustomerId() {
		return toCustomerId;
	}

	public void setToCustomerId(Integer toCustomerId) {
		this.toCustomerId = toCustomerId;
	}
	
}