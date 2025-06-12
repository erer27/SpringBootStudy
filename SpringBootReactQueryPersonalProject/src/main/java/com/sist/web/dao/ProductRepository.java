package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sist.web.entity.ProductEntity;

import java.util.*;
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
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
    @Query(value = "SELECT * FROM product ORDER BY id ASC LIMIT 4", nativeQuery = true)
    List<ProductEntity> productMainData();
    
    @Query(value = "SELECT * FROM product where category='스킨케어' ORDER BY id ASC LIMIT 4", nativeQuery = true)
    List<ProductEntity> productSCData();
    
    @Query(value = "SELECT * FROM product where category='클렌징' ORDER BY id ASC LIMIT 4", nativeQuery = true)
    List<ProductEntity> productCLData();
    
    @Query(value = "SELECT * FROM product where category='메이크업' ORDER BY id ASC LIMIT 4", nativeQuery = true)
    List<ProductEntity> productMUData();
    
    @Query(value="SELECT * "
        	  +"FROM product "
        	  + "WHERE category = :category "
        	  + "ORDER BY id ASC "
        	  +"LIMIT :start,16",nativeQuery = true)
    public List<ProductEntity> cosmeticsListData(@Param("start") int start,@Param("category") String category);
    
    @Query(value="SELECT CEIL(COUNT(*)/16.0) FROM product "
    		+ "WHERE category = :category ",nativeQuery = true)
    public int cosmeticsTotalPage(@Param("category") String category);
    
    
    // SELECT * FROM busan_food WHERE fno=?
    public ProductEntity findById(@Param("id") int id);

}






