package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import java.util.*;
import com.sist.web.vo.*;
/*
 *    public int getFno();
   public String getName();
   public String getType();
   public String getContent();
   public String getAddress();
   public int getHit();
   public int getLikecount();
   public String getPhone();
   public int getNum();
   public String getPoster();
   
   FNO        NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(500)  
TYPE       NOT NULL VARCHAR2(100)  
PHONE      NOT NULL VARCHAR2(20)   
ADDRESS    NOT NULL VARCHAR2(700)  
SCORE               NUMBER(2,1)    
THEME      NOT NULL CLOB           
POSTER     NOT NULL VARCHAR2(300)  
IMAGES              VARCHAR2(4000) 
TIME       NOT NULL VARCHAR2(100)  
PARKING             VARCHAR2(200)  
CONTENT    NOT NULL CLOB           
HIT                 NUMBER         
PRICE               VARCHAR2(30)   
JJIMCOUNT           NUMBER         
LIKECOUNT           NUMBER         
REPLYCOUNT          NUMBER         
RDAYS               VARCHAR2(200) 
 */
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
   @Query(value="SELECT fno,name,type,poster,phone,rownum "
		 +"FROM (SELECT fno,name,type,poster,phone FROM project_food ORDER BY fno) "
		 +"WHERE rownum<=10",nativeQuery = true)
   public List<FoodVO> foodMainData();
   
   @Query(value="SELECT fno,name,type,poster,phone,hit,likecount,num "
		 +"FROM (SELECT fno,name,type,poster,phone,hit,likecount,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk) */fno,name,type,poster,phone,hit,likecount "
		 +"FROM project_food)) "
		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
   public List<FoodListVO> foodListData(@Param("start") Integer start,
		   @Param("end") Integer end);
   
   
   @Query(value="SELECT fno,name,type,phone,address,score,TO_CHAR(theme) as theme,poster,"
		 +"images,time,parking,TO_CHAR(content) as content,hit,price,jjimcount,"
		 +"likecount,replycount,rdays "
		 +"FROM project_food "
		 +"WHERE fno=:fno",nativeQuery = true)
   public FoodEntity foodDetailData(@Param("fno") int fno);
}






