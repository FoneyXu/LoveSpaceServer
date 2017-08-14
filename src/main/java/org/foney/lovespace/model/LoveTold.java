package org.foney.lovespace.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LoveTold entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "love_told", catalog = "love_space")
public class LoveTold implements java.io.Serializable {

	// Fields

	private LoveToldId id;

	// Constructors

	/** default constructor */
	public LoveTold() {
	}

	/** full constructor */
	public LoveTold(LoveToldId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id")),
			@AttributeOverride(name = "name", column = @Column(name = "name", length = 20)),
			@AttributeOverride(name = "content", column = @Column(name = "content", length = 65535)),
			@AttributeOverride(name = "toldTime", column = @Column(name = "told_time", length = 19)),
			@AttributeOverride(name = "frequency", column = @Column(name = "frequency")),
			@AttributeOverride(name = "coupleId", column = @Column(name = "couple_id")),
			@AttributeOverride(name = "createTime", column = @Column(name = "create_time", length = 19)),
			@AttributeOverride(name = "createCustomerId", column = @Column(name = "create_customer_id")),
			@AttributeOverride(name = "state", column = @Column(name = "state")) })
	public LoveToldId getId() {
		return this.id;
	}

	public void setId(LoveToldId id) {
		this.id = id;
	}

}