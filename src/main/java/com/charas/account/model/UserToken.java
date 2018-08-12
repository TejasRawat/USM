package com.charas.account.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the UserToken database table.
 * 
 */
@Entity
@NamedQuery(name = "UserToken.findAll", query = "SELECT u FROM UserToken u")
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "access_token")
	private String accessToken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_use")
	private Date lastUse;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_created")
	private Date timeCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_modified")
	private Date timeModified;

	private String uuid;

	// bi-directional many-to-one association to UserSession
	@OneToMany(mappedBy = "userToken")
	private List<UserSession> userSessions;

	// bi-directional many-to-one association to Device
	@ManyToOne
	private Device device;

	// bi-directional many-to-one association to UserAccount
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccount userAccount;

	public UserToken() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getLastUse() {
		return this.lastUse;
	}

	public void setLastUse(Date lastUse) {
		this.lastUse = lastUse;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public List<UserSession> getUserSessions() {
		return this.userSessions;
	}

	public void setUserSessions(List<UserSession> userSessions) {
		this.userSessions = userSessions;
	}

	public UserSession addUserSession(UserSession userSession) {
		getUserSessions().add(userSession);
		userSession.setUserToken(this);

		return userSession;
	}

	public UserSession removeUserSession(UserSession userSession) {
		getUserSessions().remove(userSession);
		userSession.setUserToken(null);

		return userSession;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}