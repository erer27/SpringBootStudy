package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.FoodListVO;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.RecipeListVO;
import com.sist.web.dao.*;
import com.sist.web.entity.FoodEntity;

/*
 *                             | 제어 => 페이지 나누기 ... (데이터 변경이 필요)
 *     DAO(Repository) ======= Service ======= Controller
 *        |                                       |
 *      데이터베이스 연결                           클라이언트 요청한 데이터만 전송 
 */

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository fDao;
	@Override
	public List<FoodVO> foodMainData() {
		// TODO Auto-generated method stub
		return fDao.foodMainData();
	}
	@Override
	public Map foodListData(int page) {
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<FoodListVO> list=fDao.foodListData(start, end);
		int count=(int)fDao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	@Override
	public FoodEntity foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

}