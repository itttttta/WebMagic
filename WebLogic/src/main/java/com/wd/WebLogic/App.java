package com.wd.WebLogic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * Hello world!
 *
 */
public class App implements PageProcessor
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" ); .create(new App())
//        //从"https://github.com/code4craft"开始抓
//        .addUrl("https://github.com/code4craft")
//        //开启5个线程抓取
//        .thread(5)
//        //启动爬虫
//        .run();
    }
    
    
    
    
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);



	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}


	public void process(Page page) {
		 // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());		
	}

    
    
}
