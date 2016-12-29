import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.wd.CoilingDragon.Dao.CatalogueMapper;
import com.wd.CoilingDragon.Dao.ContentMapper;
import com.wd.CoilingDragon.Enity.Catalogue;
import com.wd.CoilingDragon.Enity.Content;
import com.wd.Tools.DBTools;

public class CoilingDragonTest {
	
//	@Test
//	public void insertTest(){
//		  SqlSession session = DBTools.getSession();
//	        CatalogueMapper mapper = session.getMapper(CatalogueMapper.class);
//	        Catalogue catalogue = new Catalogue();
//	        catalogue.setBookId(1);
//	        catalogue.setCatalogue("测试");
//	        catalogue.setCreateTime(new Date());
//	        catalogue.setOriginUrl("http");
//	        try {
//	            mapper.insert(catalogue);
//	            System.out.println("成功插入 :" + catalogue.toString());
//	             session.commit();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            session.rollback();
//	        }
//	}
	
	@Test
	public void contentInsertTest(){
		  SqlSession session = DBTools.getSession();
		  ContentMapper mapper = session.getMapper(ContentMapper.class);
	        Content content = new Content();
	        content.setCatalogueId(4584);
	        content.setContent("测试");
	        content.setCreateTime(new Date());
	        try {
	            mapper.insert(content);
	            System.out.println("成功插入 :" + content.toString());
	             session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }
	}
}
