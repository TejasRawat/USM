package com.charas.utility;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

public interface JsonUtil {

	public Map<String,Object> convertJsonIntoMap(String jsonString);
	
	@SuppressWarnings("rawtypes")
	public Object convertJsonIntoClass(String jsonString, Class classType);
	
	@SuppressWarnings("rawtypes")
	public Object convertJsonIntoClassList(String jsonString, Class classType);
	
	@SuppressWarnings("rawtypes")
	public Object convertJsonIntoClassReference(String jsonString, TypeReference typeReference);
	
	public String convertModelToJsonString(Object model);
	
}