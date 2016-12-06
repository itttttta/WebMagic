package com.wd.Scrapy;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.junit.Test;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class httpTest {
    static Logger log= Logger.getLogger(httpTest.class);

	@Test
	public void httpTest() throws IOException{
		OkHttpClient client = new OkHttpClient();
		    Request request = new Request.Builder().url("http://www.baidu.com").build();
		    Response response = client.newCall(request).execute();  
		    if (response.isSuccessful()) { 
		    	System.out.println(response.body().string());
		    } else {      
		    	throw new IOException("Unexpected code " + response);
		}
	}
}
