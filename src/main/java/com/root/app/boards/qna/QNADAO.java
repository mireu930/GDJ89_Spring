package com.root.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.app.boards.BoardDAO;
import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.boards.notice.NoticeDTO;
import com.root.app.pages.Pager;

@Repository
public class QNADAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.boards.qna.QNADAO.";

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"gettotalcount", pager);
	}

	@Override
	public int updatehit(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updatehit", boardDTO);
	}

	public int updateStep(QNADTO qnadto) throws Exception {
		return sqlSession.update(NAMESPACE+"updateStep",qnadto);
	}
	
	public int reply(QNADTO qnadto) throws Exception {
		System.out.println(qnadto.getBoardNum());
		return sqlSession.insert(NAMESPACE+"reply", qnadto);
	}
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getFileDetail", boardFileDTO);
	}
	
	public int deleteFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteFile", boardFileDTO);
	}
	
	public int deleteFileAll(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteFileAll", boardDTO);
	}
}
