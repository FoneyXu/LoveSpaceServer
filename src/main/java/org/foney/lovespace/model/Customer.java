package org.foney.lovespace.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer", catalog = "love_space")
public class Customer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String nickname;
	private String phone;
	private String password;
	private String sex;
	private Date birthday;
	private String headUrl;
	private Date registerTime;
	private Integer coupleCustomerId;
	private Integer coupleId;
	private Integer coupleState;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String name, String nickname, String phone,
			String password, String sex, Date birthday, String headUrl,
			Date registerTime, Integer coupleCustomerId,Integer coupleId,Integer coupleState) {
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.headUrl = headUrl;
		this.registerTime = registerTime;
		this.coupleCustomerId = coupleCustomerId;
		this.coupleId = coupleId;
		this.coupleState = coupleState;
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

	@Column(name = "nickname", length = 20)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "head_url", length = 100)
	public String getHeadUrl() {
		return this.headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	@Column(name = "register_time", length = 19)
	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "couple_state")
	public Integer getCoupleState() {
		return this.coupleState;
	}

	public void setCoupleState(Integer coupleState) {
		this.coupleState = coupleState;
	}

	@Column(name = "couple_customer_id")
	public Integer getCoupleCustomerId() {
		return coupleCustomerId;
	}

	public void setCoupleCustomerId(Integer coupleCustomerId) {
		this.coupleCustomerId = coupleCustomerId;
	}

	@Column(name = "couple_id")
	public Integer getCoupleId() {
		return coupleId;
	}

	public void setCoupleId(Integer coupleId) {
		this.coupleId = coupleId;
	}

}