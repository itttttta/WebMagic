package com.wd.WebLogic;

import com.wd.Dao.ContentMapper;
import com.wd.Enity.Content;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






public class mybatisTest {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		  ApplicationContext ctx=null;
//		  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//		  ContentMapper contentMapper=(ContentMapper) ctx.getBean("contentMapper");	  
//		  Content content = new Content();
//		  content.setId(1);
//		  content.setTitle("biaoti1");
//		  content.setContent("content1");
//		  content.setCreateTime(new Date());
//		  content.setUpdateTime(new Date());
//		  
//		  contentMapper.insert(content);
//	       System.out.println("添加成功");
//
//	}
	@Test
	public void insertTest(){
		// TODO Auto-generated method stub
		  ApplicationContext ctx=null;
		  ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		  ContentMapper contentMapper=(ContentMapper) ctx.getBean("contentMapper");	  
		  Content content = new Content();

		  content.setTitle("biaoti2");
		  content.setContent("content2");
		  content.setCreateTime(new Date());
		  content.setUpdateTime(new Date());
		  
		  contentMapper.insert(content);
	       System.out.println("添加成功");
	}
	
	

}
