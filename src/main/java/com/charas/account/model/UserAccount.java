package com.charas.account.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the UserAccount database table.
 * 
 */
@Entity
@NamedQuery(name="UserAccount.findAll", query="SELECT u FROM UserAccount u")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String lat;

	private String lon;

	private String mobile;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_created")
	private Date timeCreated;

	@Column(name="time_modified")
	private String timeModified;

	private String username;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="userAccount")
	private List<Address> addresses;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="userAccount")
	private List<Device> devices;

	//bi-directional many-to-one association to Password
	@OneToMany(mappedBy="userAccount")
	private List<Password> passwords;

	//bi-directional many-to-one association to UserToken
	@OneToMany(mappedBy="userAccount")
	private List<UserToken> userTokens;

	public UserAccount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getTimeModified() {
		return this.timeModified;
	}

	public void setTimeModified(String timeModified) {
		this.timeModified = timeModified;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUserAccount(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUserAccount(null);

		return address;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setUserAccount(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setUserAccount(null);

		return device;
	}

	public List<Password> getPasswords() {
		return this.passwords;
	}

	public void setPasswords(List<Password> passwords) {
		this.passwords = passwords;
	}

	public Password addPassword(Password password) {
		getPasswords().add(password);
		password.setUserAccount(this);

		return password;
	}

	public Password removePassword(Password password) {
		getPasswords().remove(password);
		password.setUserAccount(null);

		return password;
	}

	public List<UserToken> getUserTokens() {
		return this.userTokens;
	}

	public void setUserTokens(List<UserToken> userTokens) {
		this.userTokens = userTokens;
	}

	public UserToken addUserToken(UserToken userToken) {
		getUserTokens().add(userToken);
		userToken.setUserAccount(this);

		return userToken;
	}

	public UserToken removeUserToken(UserToken userToken) {
		getUserTokens().remove(userToken);
		userToken.setUserAccount(null);

		return userToken;
	}

}