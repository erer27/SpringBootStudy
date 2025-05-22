package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;
// => Maven / Gradle => 프로젝트 관리 , 라이브러리 관리 , 버전 관리
// => 원격 : git / svn => 형상관리
@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodMapper mapper;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO FoodDetailData(int fno) {
		// TODO Auto-generated method stub
		return mapper.FoodDetailData(fno);
	}

}