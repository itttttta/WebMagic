package com.wd.Resolve.Biquge;


import java.io.IOException;

import com.wd.Scrapy.Enity.Catalogue;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ContentResolve  {
//	 String  BiqugeBaseUrl="http:\/\/www.biquge.tw";
	String baseUrl = "http://www.biquge.tw";
	private final OkHttpClient client = new OkHttpClient();
	
	public void resolve(final Catalogue catalogue) throws IOException{	
		System.out.println("下载........"+catalogue.getCatalogue()+"章节中...... \n"
				+ catalogue.getOrigin_url());	  
		   
		  Request request = new Request.Builder()
			        .url(baseUrl+catalogue.getOrigin_url())
			        .build();

			    client.newCall(request).enqueue(new Callback() {
					
					public void onResponse(Call call, Response response) throws IOException {
						// TODO Auto-generated method stub
						System.out.println("下载成功:\n" + catalogue.getCatalogue() + response.headers());
					}
					
					public void onFailure(Call call, IOException e) {
						// TODO Auto-generated method stub
//						System.out.println("下载失败");
						System.out.println("下载失败:\n" + catalogue.getCatalogue() + call.request().url()+ e);
						

					}
				});
	}
	
	
	
	
}
