package com.root.app.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.users.UserDAO.";

	public int join(UserDTO userDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", userDTO);
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", userDTO);
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", userDTO);
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", userDTO);
	}
	
	public int upload(UserFileDTO userFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"upload", userFileDTO);
	}
	
	public int uploadUpdate(UserFileDTO userFileDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"uploadUpdate", userFileDTO);
	}
}
