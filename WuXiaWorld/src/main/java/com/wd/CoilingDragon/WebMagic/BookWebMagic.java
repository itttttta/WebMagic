package com.wd.CoilingDragon.WebMagic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import com.wd.CoilingDragon.Dao.BookMapper;
import com.wd.CoilingDragon.Dao.ContentMapper;
import com.wd.CoilingDragon.Enity.Book;
import com.wd.Tools.CoillingDragonTool;
import com.wd.Tools.DBTools;

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
		
			//href 正则
		   final String hrefRegex = "(?<=href=\").*?(?=\")";
    	   final Pattern hrefPattern = Pattern.compile(hrefRegex);
    	   //title 正则
    	   final String titleRegex = "(?<=\">).*?(?=<\\/a>)";
    	   final Pattern titlePattern = Pattern.compile(titleRegex);

    	   //数据库
    	   SqlSession session = DBTools.getSession();
    	   BookMapper mapper = session.getMapper(BookMapper.class);
    		
		// TODO Auto-generated method stub
	     List<String> complectedBookList = page.getHtml().xpath("li[@id='menu-item-12207']/ul[@class='sub-menu']/li/a").all();
	      for (int i = 0; i < complectedBookList.size(); i++) {
	    	  
	    	  //匹配href
	    	   Book book = new Book();
	    	   final Matcher hrefMatcher = hrefPattern.matcher(complectedBookList.get(i));
	    	   while (hrefMatcher.find()) {
	    		    System.out.println("href: " + hrefMatcher.group(0));
	 	    	   book.setUrl(hrefMatcher.group(0));
	    		}
	    	   //匹配title
	    	   final Matcher titleMatcher = titlePattern.matcher(complectedBookList.get(i));
	    	   while (titleMatcher.find()) {
	    		    System.out.println("title: " + titleMatcher.group(0));
		 	    	   book.setBookName(titleMatcher.group(0));
	    	   }
	    	   book.setIsComplected(1);
	    	   try {
	      	        mapper.insert(book);
	   	            System.out.println("成功插入 :"+book.toString());
	      	        session.commit();
	      	        CatalogueWebMagic catalogueWebMagic = new CatalogueWebMagic();
	      	        catalogueWebMagic.setBook(book);
	      	        catalogueWebMagic.run();
	              } catch (Exception e) {
	      	        e.printStackTrace();
	      	        session.rollback();
	              }
	    	
	    	   
		}
	      List<String> uncomplectedBookList = page.getHtml().xpath("li[@id='menu-item-2165']/ul[@class='sub-menu']/li/a").all();
	      for (int i = 0; i < uncomplectedBookList.size(); i++) {
	    	  //匹配href
//	    	   final Matcher hrefMatcher = hrefPattern.matcher(uncomplectedBookList.get(i));
//	    	   while (hrefMatcher.find()) {
//	    		    System.out.println("href: " + hrefMatcher.group(0));
//	    		}
//	    	   //匹配title
//	    	   final Matcher titleMatcher = titlePattern.matcher(uncomplectedBookList.get(i));
//	    	   while (titleMatcher.find()) {
//	    		    System.out.println("title: " + titleMatcher.group(0));
//	    	   }
//	    	   Book book = new Book();
//	    	   book.setBookName(titleMatcher.group(0));
//	    	   book.setUrl(hrefMatcher.group(0));
//	    	   book.setIsComplected( 1);
//	    	   try {
//	      	        mapper.insert(book);
//	   	            System.out.println("成功插入 :"+book.toString());
//	      	        session.commit();
//	              } catch (Exception e) {
//	      	        e.printStackTrace();
//	      	        session.rollback();
//	              }
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
