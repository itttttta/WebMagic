package com.wd.Scrapy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
//import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wd.Resolve.Biquge.CatalogueResolve;
import com.wd.Scrapy.Enity.Book;
//import org.apache.log4j.Logger;
public class ResolveTest {

//	private static Logger Logger = Logger.getLogger(ResolveTest.class);
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		
//		String resource = "com/wd/Scrapy/Mapping/BookMapper.xml";
		String resource = "SqlMapCpnfig.xml";

		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
//	@Test
//	public void insertBook(){
//		Book book = new Book();
//		book.setBookName("雪鹰领主");
//		book.setCreateTime(new Date());
//		book.setUpdateTime(new Date());
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int Sueecee =  sqlSession.insert("com.wd.Scrapy.Dao.BookMapper.insert",book);
//		sqlSession.commit();
//		System.out.println(book);
//	}
	
	@Test
	public void catalogueTest() throws IOException{
		
		CatalogueResolve catalogueResolve = new CatalogueResolve();
		catalogueResolve.resolveCatalogue("");
	}
	
	public static void main(String[] args) throws IOException{
		CatalogueResolve catalogueResolve = new CatalogueResolve();
		catalogueResolve.resolveCatalogue("");
	}
	
}
