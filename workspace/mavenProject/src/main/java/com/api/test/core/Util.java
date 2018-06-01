package com.api.test.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import com.api.test.models.UserDetails;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	private static Util util;
	
	public static Util getInstance()
    {
        if (util == null)
        	util = new Util();
        return util;
    }
	
	public List<UserDetails> getAllUserDetails(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		 List<UserDetails> userDetailList = mapper.readValue(is, new TypeReference<List<UserDetails>>(){});
		return userDetailList;
	}
	
	public List<UserDetails> convertHTTPResponseList(HttpResponse httpResponse) throws JsonParseException, JsonMappingException, IOException{
		List<UserDetails> allUserDetails = null;
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null){
            InputStream is = entity.getContent();
            allUserDetails = getAllUserDetails(is);
            if(allUserDetails!=null)
            	System.out.println("User details Size = "+allUserDetails.size());
		}
		return allUserDetails;
	}

	public StringEntity userDetailJsonString(UserDetails userDetail) throws JsonProcessingException, UnsupportedEncodingException {
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonString = mapper.writeValueAsString(userDetail);
		return new StringEntity(jsonString);
	}

	public UserDetails convertHTTPResponseUserObject(HttpResponse httpResponse) throws UnsupportedOperationException, IOException {
		UserDetails userDetails = null;
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null){
            InputStream is = entity.getContent();
            userDetails = getUserDetails(is);
            if(userDetails!=null)
            	System.out.println("User details Size = "+userDetails);
		}
		return userDetails;
	}

	UserDetails getUserDetails(InputStream is) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserDetails userDetail = mapper.readValue(is, UserDetails.class);
		return userDetail;
	}
	
}
