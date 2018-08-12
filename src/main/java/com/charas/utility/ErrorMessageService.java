package com.charas.utility;

public interface ErrorMessageService {

	public String getErrorMessage(int errorCode);

	public String getErrorMessage(int errorCode, Object... messageArgs);

	public String getMessageFromMissingParam(String fieldName);
}
