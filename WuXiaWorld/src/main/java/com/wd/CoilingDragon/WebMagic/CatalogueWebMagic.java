package com.wd.CoilingDragon.WebMagic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.wd.CoilingDragon.Dao.CatalogueMapper;
import com.wd.CoilingDragon.Enity.Book;
import com.wd.CoilingDragon.Enity.Catalogue;
import com.wd.Tools.CoillingDragonTool;
import com.wd.Tools.DBTools;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class CatalogueWebMagic implements PageProcessor{
//	public static final String URL_Base = "http://www.wuxiaworld.com/cdindex-html/";
//	public static final String Regex = "http://www.wuxiaworld.com/cdindex-html/(\\w+)/.*";

	static  Book book;
	  // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
//    private CoillingDragonTool coillingDragonTool = new CoillingDragonTool();
    SqlSession session = DBTools.getSession();
    CatalogueMapper mapper = session.getMapper(CatalogueMapper.class);
    
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        System.out.println("start");

        // 部分二：定义如何抽取页面信息，并保存下来
//        coillingDragonTool.catalogueProceeor(page.getHtml()); 
        
        List<String> chapterList = page.getHtml().xpath("//a").all();     
	       for (int i = 0; i < chapterList.size(); i++) {
	    	   String tmp = chapterList.get(i);
//	    	   System.out.println("book: "+book.getBookName()+"第"+i+"条"+tmp);
	    	   if(tmp.indexOf("http://www.wuxiaworld.com/")!=-1 && tmp.indexOf("href")!=-1 && tmp.indexOf(">Chapter")!=-1){
	    		   System.out.println("book: "+book.getBookName()+"第"+i+"条"+tmp);
	    		   Catalogue catalogue = new Catalogue();
	    		   catalogue.setBookId(book.getId());
	    		   
	    		   final String regex = "(?<=title=\")(.*?)(?=\").*(?<=href=\")(.*?)(?=\").*(?<=>)(.*?)(?=<\\/a>)";
	    		   final String string = "<a title=\"7 Killers – Chapter 1\" href=\"http://www.wuxiaworld.com/master-index/7-killers-chapter-1/\">Chapter 1 – A Meeting of Legends</a>";

	    		   final Pattern pattern = Pattern.compile(regex);
	    		   final Matcher matcher = pattern.matcher(string);

	    		   while (matcher.find()) {
	    		       System.out.println("Full match: " + matcher.group(0));
	    		       catalogue.setTitle(matcher.group(3));
	    		       catalogue.setOriginUrl(matcher.group(2));
	    		       catalogue.setSuperTitle(matcher.group(1));
	    		   }
	    		   
//	        	   final String titleRegex = "(?<=cdindex-html\\/).*?\\d+-chapter-.*?\\d+";
//	        	   final Pattern titlePattern = Pattern.compile(titleRegex);
//	        	   final Matcher titleMatcher = titlePattern.matcher(tmp);
//	        	   while (titleMatcher.find()) {
//	        	       System.out.println("title: " + titleMatcher.group(0));
//	            	   catalogue.setTitle(titleMatcher.group(0));
//	        	   }
//	        	   
//	        	   final String superTitleRegex = "(?<=cdindex-html\\/).*?\\d+";
//	        	   final Pattern superTitlePattern = Pattern.compile(superTitleRegex);
//	        	   final Matcher superTitleMatcher = superTitlePattern.matcher(tmp);
//	        	   while (superTitleMatcher.find()) {
//	        	       System.out.println("superTitle: " + superTitleMatcher.group(0));
//	            	   catalogue.setSuperTitle(superTitleMatcher.group(0));
//	        	   }
//	        	   
//	        	   final String hrefRegex = "(?<=href=\").*?(?=\")";
//	        	   final Pattern hrefPattern = Pattern.compile(hrefRegex);
//	        	   final Matcher hrefMatcher = hrefPattern.matcher(tmp);
//	        	   while (hrefMatcher.find()) {
//	           	    catalogue.setOriginUrl(hrefMatcher.group(0));
//	        	   }
//	        	   
//	        	   final String catalogueRegex = "(?<=\">).*?(?=<\\/a>)";
//	        	   final Pattern cataloguePattern = Pattern.compile(catalogueRegex);
//	        	   final Matcher catalogueMatcher = cataloguePattern.matcher(tmp);
//	        	   while (catalogueMatcher.find()) {
//	           	    catalogue.setCatalogue(catalogueMatcher.group(0));
//	        	   }	        	  
		            System.out.println("即将插入 :" + catalogue.toString());	
		            try {
	        	        mapper.insert(catalogue);
	    	            System.out.println("成功插入 :"+"第"+i+"条,"+"共"+chapterList.size()+"条" + catalogue.toString());
	        	        session.commit();
	        	        ContentWebMagic contentWebMagic = new ContentWebMagic();
	        	        contentWebMagic.setCatalogue(catalogue);
	        	        contentWebMagic.run();
	        	    } catch (Exception e) {
	        	        e.printStackTrace();
	        	        session.rollback();
	        	    }
	            }
	       	}
       
       System.out.println("over");
    }

//    @Override
    public Site getSite() {
        return site;
    }
    

    public  Book getBook() {
		return book;
	}

	public  void setBook(Book book) {
		this.book = book;
	}
	public void run() {
		Spider.create(new CatalogueWebMagic()).addPipeline(new JsonFilePipeline("/Users/wangda/Desktop/scrapy/CoilingDragon")).addUrl(book.getUrl()).thread(1).run();		
	}

}
