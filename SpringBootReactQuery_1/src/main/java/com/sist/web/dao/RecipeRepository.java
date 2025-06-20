package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>{
   @Query(value="SELECT no,poster,chef,hit,likecount,num,title "
		 +"FROM (SELECT no,poster,chef,hit,likecount,rownum as num,title "
		 +"FROM (SELECT /* INDEX_ASC(recipe recipe_no_pk)*/no,poster,chef,hit,likecount,title "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail))) "
		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
   public List<RecipeVO> recipeListData(@Param("start") Integer start,
		       @Param("end") Integer end);
   
   public RecipeEntity findByNo(int no);
   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		 +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)",nativeQuery = true)
   public int recipeTotalPage();
   // Find 
   
   public int recipeFindTotalPage(@Param("title") String title);
   // Chef 
   // Chef의 recipe목록 
   // CRUD 
}