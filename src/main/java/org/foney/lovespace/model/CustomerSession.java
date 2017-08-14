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
public class CustomerSession implements java.io.Serializable {

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
	private Integer coupleState;

	// Constructors

	/** default constructor */
	public CustomerSession() {
	}

	/** full constructor */
	public CustomerSession(String name, String nickname, String phone,
			String password, String sex, Date birthday, String headUrl,
			Date registerTime, Integer coupleState) {
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.headUrl = headUrl;
		this.registerTime = registerTime;
		this.coupleState = coupleState;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeadUrl() {
		return this.headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getCoupleState() {
		return this.coupleState;
	}

	public void setCoupleState(Integer coupleState) {
		this.coupleState = coupleState;
	}

}