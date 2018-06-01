package com.api.test.core;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import com.api.test.models.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ApiFetch {

	HttpMethodsImpl httpMethodImpl = HttpMethodsImpl.getInstance();
	Util util = Util.getInstance();
	
	
	public List<UserDetails> getAllUserDetails(String url) throws Exception{
		List<UserDetails> allUserDetails = null;
		HttpResponse httpResponse = httpMethodImpl.getHttpResponse(url);
		allUserDetails = util.convertHTTPResponseList(httpResponse);
		return allUserDetails;
	}
	
	
	public UserDetails postUserDetails(UserDetails userDetail,String url) throws Exception{
		UserDetails userDetails = null;
		StringEntity jsonEntity = util.userDetailJsonString(userDetail);
		userDetails = httpMethodImpl.postHttpResponse(url, jsonEntity);
		return userDetails;
	}
	
	public UserDetails putUserDetails(UserDetails userDetail,String url) throws Exception{
		UserDetails userDetails = null;
		StringEntity jsonEntity = util.userDetailJsonString(userDetail);
		userDetails = httpMethodImpl.putHttpResponse(url, jsonEntity);
		return userDetails;
	}
	
	
	
	
	public UserDetails deleteUserDetails(UserDetails userDetail,String url) throws Exception{
		UserDetails userDetails = null;
		StringEntity jsonEntity = util.userDetailJsonString(userDetail);
		HttpResponse httpResponse = httpMethodImpl.deleteHttpResponse(url, jsonEntity);
		userDetails = util.convertHTTPResponseUserObject(httpResponse);
		return userDetails;
	}
}
