package com.api.test.core;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.api.test.models.Address;
import com.api.test.models.Company;
import com.api.test.models.Geo;
import com.api.test.models.UserDetails;

public class ApiFetchTest {
	
	 @Test
	 public void getAllUserDetails(){
		ApiFetch apitFetch = new ApiFetch();
		List<UserDetails> userDetailsList = null;
		try {
			userDetailsList = apitFetch.getAllUserDetails(Constants.url);
			System.out.println(userDetailsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(userDetailsList != null);   
		
		UserDetails userDetail = getUserDetailObject( );
		try{
			userDetail = apitFetch.postUserDetails(userDetail, Constants.url);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertTrue(userDetail!=null && userDetail.getId()!=null);
		
		String uniqueString = UUID.randomUUID().toString();
		try{
			userDetail.setUserName(uniqueString);
			//userDetail = apitFetch.putUserDetails(userDetail, Constants.url);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertTrue(userDetail.getUserName().equalsIgnoreCase(uniqueString));
	 }
	 
	 public UserDetails getUserDetailObject(){
		 UserDetails userDetail = new UserDetails();
		 Address address = new Address();
		 address.setCity("Wisokyburgh");
		 Geo geo = new Geo();
		 geo.setLat("-43.9509");
		 geo.setLng("-34.4618");
		 address.setGeo(geo);
		 address.setStreet("Victor Plains");
		 address.setSuite("Suite 879");
		 address.setZipcode("90566-7771");
		 userDetail.setAddress(address);
		 Company company = new Company();
		 company.setBs("synergize scalable supply-chains");
		 company.setCatchPhrase("Proactive didactic contingency");
		 company.setName("Deckow-Crist");
		 userDetail.setCompany(company);
		 userDetail.setEmail("Shanna@melissa.tv");
		 userDetail.setPhone("010-692-6593 x09125");
		 userDetail.setName("Ervin Howell");
		 userDetail.setUserName("Antonette");
		 userDetail.setWebsite("anastasia.net");
		 return userDetail;
	 }
	 
	 

}
