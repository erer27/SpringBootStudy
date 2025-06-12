package com.sist.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
import com.sist.web.dao.*;
/*
 *    DAO : table 한개 담당 
 *    Service : 여러개 table 모아서 담당 
 *              DAO여러개 
 *              DAO와 다른 기능이 있는 경우 
 *   ------------------------------------- 의존성이 낮은 프로그램 
 *   
 *             | 처리=> 실무에서는  
 *   => DAO = Service = Controller 
 *       |                  |
 *     데이터베이스 연동      브라우저로 값을 전송 
 *     
 *   => DAO / Service의 차이점 => 95%
 *   이력서 => 
 *            1. 기술면접 
 *            2. 코딩 테스트 : 중견업체 
 *            3. 테스트지 
 *            ----------------------- 인성면접 ---------- 계약서 
 */
@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeRepository rDao;
    @Autowired
    private RecipeDetailRepository rdDao;
    
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start,end);
	}

	@Override
	public Map recipeDetailData(int no) {
		// TODO Auto-generated method stub
		  Map map=new HashMap();
		  RecipeDetailEntity vo=rdDao.findByNo(no);
		  String[] datas=vo.getFoodmake().split("\n");
		  List<String> mList=new ArrayList<String>();
		  List<String> iList=new ArrayList<String>();
		  
		  for(String d:datas)
		  {
			  StringTokenizer st=new StringTokenizer(d,"^");
			  mList.add(st.nextToken());
			  iList.add(st.nextToken());
		  }
		  
		  String s=vo.getData();
		  s=s.replaceAll("[구매]", "");
		  vo.setData(s);
		  String[] arr=s.split(",");
		  List<String> dList=Arrays.asList(arr);
		  
		  map.put("vo", vo);
		  map.put("dList", dList);
		  map.put("mList", mList);
		  map.put("iList", iList);
		return map;
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

}