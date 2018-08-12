package com.charas.account.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the UserSession database table.
 * 
 */
@Entity
@NamedQuery(name="UserSession.findAll", query="SELECT u FROM UserSession u")
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cart_id")
	private String cartId;

	@Column(name="invoice_id")
	private String invoiceId;

	@Column(name="ip_address")
	private String ipAddress;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="user_agent")
	private String userAgent;

	//bi-directional many-to-one association to UserToken
	@ManyToOne
	@JoinColumn(name="user_token_id")
	private UserToken userToken;

	public UserSession() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCartId() {
		return this.cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public UserToken getUserToken() {
		return this.userToken;
	}

	public void setUserToken(UserToken userToken) {
		this.userToken = userToken;
	}

}