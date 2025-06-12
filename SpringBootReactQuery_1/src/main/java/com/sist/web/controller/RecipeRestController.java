package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;
@RestController
@CrossOrigin(origins = "*")
public class RecipeRestController {
  @Autowired
  private RecipeService rService;
  // const {isLoading,error,data}=useQuery() => 3 => tanStack-Query : 기능 추가 
  //                                                 오픈 소스 그룹 
  // 일반 => 권장 : JavaScript / TypeScript (가독성) 
  // Redux => TanStack-Query => ThymeLeaf (Git Actions , Docker) => CI/CD 
  // 본인 PR 
  
  @GetMapping("/recipe/list/{page}")
  public ResponseEntity<Map> food_list(@PathVariable("page") int page)
  {
	  Map map=new HashMap();
	  try
	  {
		  int rowSize=12;
		  int start=(rowSize*page)-(rowSize-1);
		  int end=rowSize*page;
		  List<RecipeVO> list=rService.recipeListData(start, end);
		  int totalpage=rService.recipeTotalPage();
		  
		  final int BLOCK=10;
		  int startPage=((page-1)/BLOCK*BLOCK)+1;
		  int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		  
		  if (endPage>totalpage)
			   endPage=totalpage;
		  
		  map.put("fList", list);
		  map.put("curpage", page);
		  map.put("totalpage", totalpage);
		  map.put("startPage", startPage);
		  map.put("endPage", endPage);
		  
		  /*
		   *    javascript 
		   *    
		   *    => JSON
		   *    List => []
		   *    Map => {} => 데이터를 여러개 모아서 전송 
		   *    VO => {}
		   */
		  
	  }catch(Exception ex)
	  {
		  return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  return new ResponseEntity<>(map,HttpStatus.OK); // 정상 수행 => 200
  }
  @GetMapping("/recipe/detail/{no}")
  public ResponseEntity<Map> recipe_detail(@PathVariable("no") int no)
  {
	  Map map=new HashMap();
	  try
	  {
		  map=rService.recipeDetailData(no);
		  
	  }catch(Exception ex)
	  {
		  return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  return new ResponseEntity<>(map,HttpStatus.OK);
  }
  
}