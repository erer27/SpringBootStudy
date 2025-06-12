package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
// cookie / session 
public interface RecipeService {
	public List<RecipeVO> recipeListData(int start,int end);
    public int recipeTotalPage();
    public Map recipeDetailData(int no);
}