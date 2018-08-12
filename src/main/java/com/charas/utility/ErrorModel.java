package com.charas.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the model of error contract b/w UI & third party consumers It
 * contains errorCode, errorMesage & MessageService that picks the errorMessage
 * from property file based on the locale
 * 
 * @author te303950
 */
public class ErrorModel {

	@JsonProperty("code")
	private int errorCode;

	@JsonProperty("message")
	private String errorMessage;

	@JsonIgnore
	private ErrorMessageService messageService = (ErrorMessageService) ApplicationContextHelper
			.getBean(ErrorMessageServiceImpl.class);

	public ErrorModel() {

	}

	public ErrorModel(int errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = messageService.getErrorMessage(errorCode);
	}

	public ErrorModel(int errorCode, Object... messageArgs) {
		this.errorCode = errorCode;
		this.errorMessage = messageService.getErrorMessage(errorCode, messageArgs);
	}
	
	public ErrorModel(String fieldName) {
		this.errorCode = 0;
		this.errorMessage = messageService.getMessageFromMissingParam(fieldName);
	}

	public ErrorModel(int errorCode, String message) {
		this.errorCode = errorCode;
		this.errorMessage = message;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorModel [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
