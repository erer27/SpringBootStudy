package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.RecipeDetailEntity;
/*
 *   NO           NOT NULL NUMBER         
	POSTER       NOT NULL VARCHAR2(4000) 
	TITLE        NOT NULL VARCHAR2(1000) 
	CHEF         NOT NULL VARCHAR2(1000) 
	CHEF_POSTER  NOT NULL VARCHAR2(1000) 
	CHEF_PROFILE NOT NULL VARCHAR2(1000) 
	INFO1        NOT NULL VARCHAR2(100)  
	INFO2        NOT NULL VARCHAR2(100)  
	INFO3        NOT NULL VARCHAR2(100)  
	CONTENT      NOT NULL VARCHAR2(4000) 
	FOODMAKE     NOT NULL CLOB           
	DATA                  CLOB           
	LIKECOUNT             NUMBER   
 */
public interface RecipeDetailRepository extends JpaRepository<RecipeDetailEntity, Integer>{
    @Query(value="SELECT no,poster,title,chef,chef_poster,chef_profile,info1,info2,"
    	  +"info3,content,TO_CHAR(foodmake) as foodmake,TO_CHAR(data) as data,likecount "
    	  +"FROM recipedetail WHERE no=:no",nativeQuery = true)
    public RecipeDetailEntity recipeDetailData(@Param("no") int no);
}