package com.sist.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sist.web.entity.CommentEntity;
import com.sist.web.entity.MemberEntity;
import com.sist.web.vo.CommentVO;
import com.sist.web.dao.*;
// => Ajax를 이용한 동적페이지 : Ajax => Vue / React 
//                                   | Nuxt | Next         => JavaScript : 가독성(X) 
//                                                             | TypeScript 
// DAO VS Service :
/*
 *     class A
 *     {
 *       int a,b,c,d,e,f; 
 *     }
 */
@Service
public class CommentServiceImpl implements CommentService{
    
	@Autowired 
	private MemberRepository mDao;
	
	@Autowired
	private CommentRepository cDao;
	// => id 존재여부 확인 
	@Override
	public int idCount(String id) {
		// TODO Auto-generated method stub
		return mDao.idCount(id);
	}
    // => 비밀번호 =>  데이터 전송 => react 
	@Override
	public MemberEntity memberDetailData(String id) {
		// TODO Auto-generated method stub
		return mDao.memberDetailData(id);
	}
	@Override
	public List<CommentVO> commentListData(int fno) {
		// TODO Auto-generated method stub
		return commentCommonsData(fno);
	}
	
	public List<CommentVO> commentCommonsData(int fno)
	{
		return cDao.commentListData(fno);
	}
	// insert / update / delete
	// data가 변경이 되는 화면 UI에 적용 
	@Override
	public List<CommentVO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		int no=cDao.MaxNo();
		vo.setNo(no);
		vo.setRegdate(new Date()); // id,name,fno,msg 
		cDao.save(vo);
		return commentCommonsData(vo.getFno());
	}
	@Override
	public List<CommentVO> commentDelete(int no,int fno) {
		// TODO Auto-generated method stub
		CommentEntity vo=cDao.findByNo(no);
		cDao.delete(vo);
		return commentCommonsData(fno);
	}
	@Override
	public List<CommentVO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo=cDao.findByNo(no);
		vo.setMsg(msg);
		vo.setNo(no);
		cDao.save(vo);
		return commentCommonsData(no);
	}
}









