package com.root.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.app.boards.CommentDTO;
import com.root.app.pages.Pager;
import com.root.app.utils.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.products.ProductDAO.";
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		
		List<ProductDTO> ar = sqlSession.selectList(NAMESPACE+"getList", pager);
		return ar;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+"add", productDTO);
		
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		productDTO = sqlSession.selectOne(NAMESPACE+"getDetail", productDTO);
		
		return productDTO;
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		
		int result = sqlSession.update(NAMESPACE+"update", productDTO);
	
		return result;
	}
	
	public int delte(ProductDTO productDTO) throws Exception {
		
		int result = sqlSession.delete(NAMESPACE+"delete", productDTO);
		
		return result;
	}
	
	public Long gettotalcount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"gettotalcount", pager);
	}
	
	public int upload(ProductFileDTO productFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"upload", productFileDTO);
	}
	
	public int updateUpload(ProductFileDTO productFileDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateUpload", productFileDTO);
	}
	
	public int getCommentsadd(CommentsDTO commnetsDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"getCommentsadd", commnetsDTO);
	}
	
	public List<CommentsDTO> getCommentList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
	}
	
	public Long getCommentCount(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCommentCount", commentsDTO);
	}
	
	public int getCommentDelete(CommentsDTO commentsDTO) throws Exception {
		System.out.println("dao"+commentsDTO.getBoardNum());
		return sqlSession.delete(NAMESPACE+"getCommentDelete", NAMESPACE);
	}
}
