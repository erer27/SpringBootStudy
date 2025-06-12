package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;

public interface BusanFoodService {
	public Map busanFoodListData(int page);
    public BusanFoodEntity busanFoodDetailData(int fno);
    public int busanFoodTotalPage();
    
    public Map busanInfoListData(int page);
    public BusanInfoEntity busanIndoDetailData(int no);
}