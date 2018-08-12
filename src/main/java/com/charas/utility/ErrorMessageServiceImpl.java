package com.charas.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageServiceImpl implements ErrorMessageService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getErrorMessage(int errorCode) {
		String messageCode = "error_code" + errorCode;
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(messageCode, null, locale);
	}

	@Override
	public String getErrorMessage(int errorCode, Object... messageArgs) {
		String messageCode = "error_code" + errorCode;
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(messageCode, messageArgs, locale);
	}

	@Override
	public String getMessageFromMissingParam(String fieldName) {
		String messageCode = "error_missing_param" + fieldName;
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(messageCode, null, locale);
	}

}
