package com.charas.utility;

import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;

public interface RestClient {

	public RestClient setURL(String url);

	public RestClient setURLAndContentType(String url, String contentType);
	
	public RestClient setHeader(String key, String value);

	public RestClient setHeader(LinkedMultiValueMap<String, String> requestHeader);

	public RestClient addURLParam(String key, String value);

	public RestClient addURLParam(Map<String, String> params);

	public RestClient setBody(Object Body);

	public String get();

	public String post();

	public String put();

	public String delete();

}
