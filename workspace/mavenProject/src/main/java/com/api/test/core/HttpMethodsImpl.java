package com.api.test.core;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import com.api.test.models.UserDetails;

public class HttpMethodsImpl {
	
	CloseableHttpClient httpclient = null;
	HttpGet request = null;
	private Long connectionTimeOut;
	
	private static HttpMethodsImpl httpMethodsImpl_instance = null;
	 
	
	 // static method to create instance of Singleton class
    public static HttpMethodsImpl getInstance()
    {
        if (httpMethodsImpl_instance == null)
        	httpMethodsImpl_instance = new HttpMethodsImpl(1000l);
        return httpMethodsImpl_instance;
    }
	 
	public HttpMethodsImpl(Long connectionTimeOut) {
		// TODO Auto-generated constructor stub
		this.connectionTimeOut=connectionTimeOut;
	}
	
	public HttpResponse getHttpResponse(String url) throws Exception {
		HttpResponse response = null;
		try {
			request = new HttpGet(url);
			httpclient = HttpClients.createDefault();
			
			RequestConfig requestConfig = RequestConfig.custom()
					  .setSocketTimeout(connectionTimeOut.intValue())
					  .setConnectTimeout(connectionTimeOut.intValue())
					  .setConnectionRequestTimeout(connectionTimeOut.intValue())
					  .build();
			request.setConfig(requestConfig);
			System.out.println("\n Http Connection befor execute : ");
			response = httpclient.execute(request);
			System.out.println("\n Http Connection executed Succesfully : ");
		}
		catch (Exception e) {
			System.out.println("\n Http Connection  : "+e.getMessage());
			throw e;
		}
		
		return response;
	}
	
	public UserDetails postHttpResponse(String url,StringEntity data) throws Exception {
		HttpResponse response = null;
		UserDetails jsonString = null;
		Util util = new Util();
			request = new HttpGet(url);
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			try {
			    HttpPost request = new HttpPost(url);
			    RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(connectionTimeOut.intValue())
						  .setConnectTimeout(connectionTimeOut.intValue())
						  .setConnectionRequestTimeout(connectionTimeOut.intValue())
						  .build();
			    request.setConfig(requestConfig);
			    request.addHeader("content-type", "application/json");
			    request.setEntity(data);
			    response = httpClient.execute(request);
			    HttpEntity entity = response.getEntity();
				if (entity != null){
		            InputStream is = entity.getContent();
		             jsonString = util.getUserDetails( is);
				}
			// handle response here...
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			    httpClient.close();
			}
		
		return jsonString;
	}
	
	public void closeHttp(){
		if (request != null && httpclient != null) {
			request.releaseConnection();
			try {
				httpclient.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public HttpResponse deleteHttpResponse(String url, StringEntity jsonEntity) throws Exception {
		HttpResponse response = null;
		try {
			request = new HttpGet(url);
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			try {
			    HttpPut request = new HttpPut(url);
			    RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(connectionTimeOut.intValue())
						  .setConnectTimeout(connectionTimeOut.intValue())
						  .setConnectionRequestTimeout(connectionTimeOut.intValue())
						  .build();
			    request.setConfig(requestConfig);
			    request.addHeader("content-type", "application/json");
			    request.setEntity(jsonEntity);
			    httpClient.execute(request);
			// handle response here...
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			    httpClient.close();
			}
		}
		catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	public UserDetails putHttpResponse(String url, StringEntity jsonEntity) throws Exception {
		HttpResponse response = null;
		UserDetails jsonString = null;
		Util util = new Util();
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			try {
			    HttpPut request = new HttpPut(url);
			    RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(connectionTimeOut.intValue())
						  .setConnectTimeout(connectionTimeOut.intValue())
						  .setConnectionRequestTimeout(connectionTimeOut.intValue())
						  .build();
			    request.setConfig(requestConfig);
			    request.addHeader("content-type", "application/json");
			    request.setEntity(jsonEntity);
			    response = httpClient.execute(request);
			    HttpEntity entity = response.getEntity();
				if (entity != null){
		            InputStream is = entity.getContent();
		             jsonString = util.getUserDetails( is);
				}
			// handle response here...
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			    httpClient.close();
			}
		
		return jsonString;
	}
	

}
