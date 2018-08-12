package com.charas.account.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Device database table.
 * 
 */
@Entity
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String imei;

	private String model;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_created")
	private Date timeCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_modified")
	private Date timeModified;

	private String uuid;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserAccount userAccount;

	//bi-directional many-to-one association to UserToken
	@OneToMany(mappedBy="device")
	private List<UserToken> userTokens;

	public Device() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeModified() {
		return this.timeModified;
	}

	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserToken> getUserTokens() {
		return this.userTokens;
	}

	public void setUserTokens(List<UserToken> userTokens) {
		this.userTokens = userTokens;
	}

	public UserToken addUserToken(UserToken userToken) {
		getUserTokens().add(userToken);
		userToken.setDevice(this);

		return userToken;
	}

	public UserToken removeUserToken(UserToken userToken) {
		getUserTokens().remove(userToken);
		userToken.setDevice(null);

		return userToken;
	}

}