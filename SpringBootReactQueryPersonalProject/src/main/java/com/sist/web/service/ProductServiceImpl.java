package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.ProductEntity;

/*
 *                             | 제어 => 페이지 나누기 ... (데이터 변경이 필요)
 *     DAO(Repository) ======= Service ======= Controller
 *        |                                       |
 *      데이터베이스 연결                           클라이언트 요청한 데이터만 전송 
 */

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository pDao;

	@Override
	public Map productMainData() {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		List<ProductEntity> SC = pDao.productSCData();
		List<ProductEntity> CL = pDao.productCLData();
		List<ProductEntity> MU = pDao.productMUData();
		map.put("SC", SC);
		map.put("CL", CL);
		map.put("MU", MU);
		return map;
	}

	@Override
	public Map cosmeticsListData(int page, String category) {
		// TODO Auto-generated method stub
		System.out.println(category);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(page-1)*rowSize;
	   List<ProductEntity> list=pDao.cosmeticsListData(start, category);
	   int totalpage=pDao.cosmeticsTotalPage(category);
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   map.put("list", list);
	   return map;
	}

	@Override
	public ProductEntity cosmeticsDetail(int id) {
		// TODO Auto-generated method stub
		return pDao.findById(id);
	}


}