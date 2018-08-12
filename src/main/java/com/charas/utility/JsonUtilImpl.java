package com.charas.utility;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilImpl implements JsonUtil {
	
	private static final Logger LOG = Logger.getLogger(JsonUtilImpl.class);
	
	
	@Override
	public Map<String, Object> convertJsonIntoMap(String jsonString) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		if(jsonString==null || jsonString.isEmpty()){
			return result;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			result = objectMapper.readValue(jsonString,new TypeReference<Map<String,Object>>(){});
		} catch (IOException e) {
			LOG.info(e.getStackTrace());
		}
		
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object convertJsonIntoClass(String jsonString, Class classType) {
		Object result = null;
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			result = objectMapper.readValue(jsonString,classType);
		} catch (IOException e) {
			LOG.info(e.getStackTrace());
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertJsonIntoClassList(String jsonString, Class classType) {
		Object result = null;
		
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			
			JsonNode jsonObject = objectMapper.readTree(jsonString);
			
			if(jsonObject.has("Erros")){
				JsonNode erros = jsonObject.get("Errors");
				LOG.info(erros.get("ErrorCode"));
				LOG.info(erros.get("Message"));
				return result;
			}
			
			if(!jsonObject.has("Result") || jsonObject.get("Result") == null){
				return result;
			}
			
			result = objectMapper.readValue(jsonObject.get("Result").toString(),
					objectMapper.getTypeFactory().constructCollectionType(List.class, classType));
			
		}catch (IOException e) {
			LOG.info(e.getStackTrace());
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertJsonIntoClassReference(String jsonString, TypeReference typeReference) {
		Object result = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			result = objectMapper.readValue(jsonString, typeReference);
			
		}catch (IOException e) {
			LOG.info(e.getStackTrace());
		}
		return result;
	}

	@Override
	public String convertModelToJsonString(Object model) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = null;
		
		try{
			jsonStr = objectMapper.writeValueAsString(model);
		}catch (IOException e) {
			LOG.info(e.getStackTrace());
		}

		return jsonStr;
	}

}
