package com.root.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getTotalCount();
		Long totalPage = totalCount/5;
		
		if(totalPage %5 !=0) {
			totalPage++;
		}
		
		Long totalBlock = (long)Math.ceil(totalPage/5.0);
		Long curBlock = (long)Math.ceil(pager.getPage()/5.0);
		
		Long start = (curBlock-1)*5+1;
		Long end = curBlock*5;
		
		pager.setStart(start);
//		pager.setEnd(end);
		
		if(totalBlock == curBlock) {
			pager.setEnd(totalPage);
		}
		
//		pager.setPage(totalPage);
		pager.makeNum();
		
		return noticeDAO.getList();
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO, boolean check) throws Exception {
		if(check) {
			noticeDAO.updatehit(noticeDTO);
		}
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
}
