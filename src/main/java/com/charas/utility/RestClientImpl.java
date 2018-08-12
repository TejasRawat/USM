package com.charas.utility;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class RestClientImpl implements RestClient {

	private String url;
	private Object body;
	private Map<String,String> urlParams;
	private MultiValueMap<String, String> headers;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public RestClient setURL(String url) {
		this.url = url;
		headers = new LinkedMultiValueMap<String,String>();
		headers.add("content-type", "application/json");
		return this;
	}

	@Override
	public RestClient setURLAndContentType(String url, String contentType) {
		this.url = url;
		headers = new LinkedMultiValueMap<String,String>();
		headers.add("content-type", contentType);
		return this;
	}
	
	@Override
	public RestClient setHeader(String key, String value) {
		if(key!=null && !key.isEmpty() && value!= null && !value.isEmpty() ){
			headers.add(key, value);
		}
		return this;
	}

	@Override
	public RestClient setHeader(LinkedMultiValueMap<String, String> requestHeader) {
		if(requestHeader!= null){
			headers.putAll(requestHeader);
		}
		return this;
	}

	@Override
	public RestClient addURLParam(String key, String value) {
		if(key!=null && !key.isEmpty() && value!= null && !value.isEmpty() ){
			if(this.urlParams == null){
				this.urlParams = new HashMap<String,String>();
			}
			this.urlParams.put(key, value);
		}
		return this;
	}

	@Override
	public RestClient addURLParam(Map<String, String> params) {
		if(params != null){
			if(this.urlParams == null){
				this.urlParams = new HashMap<String,String>();
			}
			this.urlParams.putAll(params);
		}
		return this;
	}

	@Override
	public RestClient setBody(Object body) {
		this.body = body;
		return this;
	}
	
	private void setURLParams() {
		if(this.urlParams!= null ){
			Iterator<Entry<String, String>> itr = this.urlParams.entrySet().iterator();
				while(itr.hasNext()){
					Entry<String, String> entry = itr.next();
						if(this.url.contains("?")){
							this.url = this.url + "&" + entry.getKey() + "=" + entry.getValue();
						}else{
							this.url = this.url + "?" + entry.getKey() + "=" + entry.getValue();
						}
				}
		}
	}

	@Override
	public String get() {
		String result = null;
		
		if(this.url != null && !this.url.isEmpty()){
			this.setURLParams();
			HttpEntity<String> requestHeader = new HttpEntity<String>(headers);
			ResponseEntity<String> response  = restTemplate.exchange(
										this.url, HttpMethod.GET,requestHeader,String.class);
			result = response.getBody();
		}
		return result;
	}

	@Override
	public String post() {
		String result = null;
		
		if(this.url != null && !this.url.isEmpty()){
			this.setURLParams();
			HttpEntity<Object> requestHeaderAndBody = new HttpEntity<Object>(this.body,headers);
			ResponseEntity<String> response  = restTemplate.exchange(
										this.url, HttpMethod.POST,requestHeaderAndBody,String.class);
			result = response.getBody();
		}
		return result;	
	}

	@Override
	public String put() {
		String result = null;
		
		if(this.url != null && !this.url.isEmpty()){
			this.setURLParams();
			HttpEntity<Object> requestHeaderAndBody = new HttpEntity<Object>(this.body,headers);
			ResponseEntity<String> response  = restTemplate.exchange(
										this.url, HttpMethod.PUT,requestHeaderAndBody,String.class);
			result = response.getBody();
		}
		return result;		
	}

	@Override
	public String delete() {
		String result = null;
		
		if(this.url != null && !this.url.isEmpty()){
			this.setURLParams();
			HttpEntity<String> requestHeader = new HttpEntity<String>(headers);
			ResponseEntity<String> response  = restTemplate.exchange(
										this.url, HttpMethod.DELETE,requestHeader,String.class);
			result = response.getBody();
		}
		return result;	
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getUrlParams() {
		return urlParams;
	}

	public void setUrlParams(Map<String, String> urlParams) {
		this.urlParams = urlParams;
	}

	public MultiValueMap<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(MultiValueMap<String, String> headers) {
		this.headers = headers;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Object getBody() {
		return body;
	}
	
	

}
