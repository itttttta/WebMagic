package com.wd.CoilingDragon.WebMagic;

import java.util.List;

import com.wd.Tools.CoillingDragonTool;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class BookWebMagic implements PageProcessor{

	
	public static final String URL_Base = "http://www.wuxiaworld.com";
	public static final String Regex_Base_Url = "http:\\/\\/www.wuxiaworld.com\\/.*?\\/";

//	public static final String Regex = "http://www.wuxiaworld.com/cdindex-html/(\\w+)/.*";

	  // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
    
	public void process(Page page) {
		System.out.println("start");
		// TODO Auto-generated method stub
	     List<String> complectedBookList = page.getHtml().xpath("li[@id='menu-item-12207']/ul[@class='sub-menu']/li/a").all();
	      for (int i = 0; i < complectedBookList.size(); i++) {
	    	   System.out.println(i+"compected:  "+complectedBookList.get(i));
		}
	      List<String> uncomplectedBookList = page.getHtml().xpath("li[@id='menu-item-2165']/ul[@class='sub-menu']/li/a").all();
	      for (int i = 0; i < uncomplectedBookList.size(); i++) {
	    	   System.out.println(i+"uncompected"+uncomplectedBookList.get(i));
		}
	     System.out.println("over");
	}

	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}
	
	  public static void main(String[] args) {

	        Spider.create(new BookWebMagic())
	                //从"https://github.com/code4craft"开始抓
	                .addUrl(URL_Base)
	                .addPipeline(new JsonFilePipeline("/Users/wangda/Desktop/scrapy/Book"))
	                //开启5个线程抓取
	                .thread(3)
	                //启动爬虫
	                .run();
	    }

}
