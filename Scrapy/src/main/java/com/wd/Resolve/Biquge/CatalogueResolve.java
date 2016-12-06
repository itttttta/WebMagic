package com.wd.Resolve.Biquge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wd.Scrapy.Enity.Catalogue;


public class CatalogueResolve {

	private SqlSessionFactory sqlSessionFactory;
	
	 public void resolveCatalogue(String httpString) throws IOException{
		
		final String regex = "<dd>.*?<\\/dd>";
		final String string = "\n"
			
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134698.html\">第十六篇 监察使 第32章 求饶</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134699.html\">第十六篇 监察使 第33章 发现</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134700.html\">第十六篇 监察使 第34章 出手</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134701.html\">第十六篇 监察使 第35章 吃我一枪</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134702.html\">第十六篇 第36章 退去</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134703.html\">第十七篇 纵横 第一章 妻子身份</a></dd>\n"
			 + "                    \n"
			 + "                    \n"
			 + "                    <dt>《雪鹰领主》第十七篇纵横</dt>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134704.html\">第十七篇 第二章 名传各方</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134705.html\">第十七篇 第三章 送礼</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134706.html\">第十七篇 第四章 毒郢的末路</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134707.html\">第十七篇 第四章 毒郢的末路</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134708.html\">第十七篇 第五章 器具</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134709.html\">第十七篇 第六章 《黑虫经》</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134710.html\">第十七篇 第七章 解脱</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134711.html\">第十七篇 第八章 大事件 上</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134712.html\">第十七篇 第九章 大事件 下</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134713.html\">第十七篇 第十章 传话</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134714.html\">请假一天</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134715.html\">第十七篇 纵横 第十一章 湖心岛</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134716.html\">第十七篇 纵横 第十二章 陨石府邸</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134717.html\">第七篇 纵横 第十三章 天云帝君</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134718.html\">第十七篇 纵横 第十四章 未低头</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134719.html\">第十七篇 纵横 第十五章 十一年</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134720.html\">第十七篇 纵横 第十六章 初入洞窟</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134721.html\">第十七篇 纵横 第十七章 苏醒的老家伙们</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134722.html\">第十七篇 第十八章 血火之门</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134723.html\">第十七篇 第19章 危急!</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134724.html\">第十七篇 第20章 战死,朋友</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134725.html\">第十七篇 第21章 多足兽</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134726.html\">第十七篇 第22章 赌对了</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134727.html\">第十七篇 第23章 再战血火之门</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134728.html\">第十七篇 第24章 湖心岛的宾客</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134729.html\">第十七篇 第25章 父亲‘摩雪国主’</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134730.html\">第十七篇 第26章 寒冰层下的灰袍男子</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134731.html\">第十七篇 第27章 留言</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134732.html\">第十七篇 第28章 进入 本篇终</a></dd>\n"
			 + "                    \n"
			 + "                    \n"
			 + "                    <dt>《雪鹰领主》第十八篇归来</dt>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134733.html\">第十八篇 归来 第一章 打了再说</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134734.html\">第十八篇 归来 第二章 耻辱</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134735.html\">第十八篇 归来 第三章 我加入</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134736.html\">第十八篇 归来 第四章 庞依</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134737.html\">第十八篇 归来 第五章 功成四转</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134738.html\">第十五篇 归来 第六章 封禁本尊神心</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134739.html\">第十八篇 归来 第七章 靠身体的力量</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134740.html\">第十八篇 归来 第八章 力量爆发</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134741.html\">第十八篇 第九章 最后的考验</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134742.html\">第十八篇 第十章 意志!</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134743.html\">第十八篇 第十一章 世界如此精彩</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134744.html\">第十八篇 第十二章 意志破除禁制!</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134745.html\">第十八篇 第十三章 属于我的真神器</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134746.html\">第十八篇 第十四章 归来</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134747.html\">第十八篇 第十五章 擒下!</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134748.html\">第十八篇 第十六章 火铖尊者</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134749.html\">第十八篇 第十七章 大好处</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134750.html\">第十八篇 第十八章 元初主人</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134751.html\">第十八篇 第十九章 六个人</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134752.html\">第十八篇 第二十章 馆主 本篇终</a></dd>\n"
			 + "                    \n"
			 + "                    <dd> <a style=\"\" href=\"/9_9080/5134753.html\">第十九篇 深渊 第一章 准备</a></dd>\n"
			 + "                    \n"
			 + "                    \n";
			

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(string);

		

		
//		String resource = "com/wd/Scrapy/Mapping/BookMapper.xml";
		String resource = "SqlMapCpnfig.xml";

		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		while (matcher.find()) {
			
			String itemString = matcher.group(0);
			String title =  itemString.substring(itemString.indexOf("\">")+2,itemString.indexOf("</a"));
			String url =  itemString.substring(itemString.indexOf("href=\"")+6,itemString.indexOf("\">"));

		    System.out.println("title " + title);
		    System.out.println("url: " + url);

		    Catalogue catalogue = new Catalogue();
		    catalogue.setBookId(4);
		    catalogue.setCatalogue(title);
		    catalogue.setOrigin_url(url);
		    catalogue.setUpdateTime(new Date());
		    catalogue.setUpdateTime(new Date());
		    
		    
		    
			
//			int Sueecee =  sqlSession.insert("com.wd.Scrapy.Dao.CatalogueMapper.insert",catalogue);
//			sqlSession.commit();
			ContentResolve contentResolve = new ContentResolve();
			contentResolve.resolve(catalogue);
			System.out.println(catalogue);
		    
		}
//		System.out.println("已全部完成.....");
		
	}
}
