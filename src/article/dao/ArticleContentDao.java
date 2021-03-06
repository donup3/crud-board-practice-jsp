package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	public ArticleContent insert(Connection conn,ArticleContent content) throws SQLException {
		try (PreparedStatement pstmt=conn.prepareStatement("insert into article_content (article_no, content) values(?,?)");){
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertCnt=pstmt.executeUpdate();
			if(insertCnt>0) {
				return content;
			}
			return null;
		}
	}
	public void contentUpdate(Connection conn,int no,String content) throws SQLException {
		try(PreparedStatement pstmt=conn.prepareStatement("update article_content set content=? where article_no=?");){
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		}
	}
	public void delete(Connection conn,int no) throws SQLException {
		try(PreparedStatement pstmt=conn.prepareStatement("delete from article_content where article_no=?")){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	public ArticleContent selectById(Connection conn,int no) throws SQLException {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement("select *from article_content where article_no=?");
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			ArticleContent content=null;
			if(rs.next()) {
				content=new ArticleContent(rs.getInt("article_no"),rs.getString("content"));
			}
			return content;
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
	}
}
