package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class MovieRestController {
	
   @Autowired
   private MovieService mService;
   
   @GetMapping("/main_react")
   public Map main_data() throws Exception
   {
	   
	   Map map=new HashMap();
	   List<MovieEntity> list=mService.movieMainData();
	   
	   map.put("list", list);


	   return map;
   }
   
   @GetMapping("/movie/detail_react")
   public MovieEntity food_detail(@RequestParam("id") int id)
   {
	   MovieEntity vo=mService.findById(id);
	   return vo;
   }
   
   @GetMapping("/movie/list_react" )
   public Map movie_list_data(@RequestParam("page") int page) throws Exception
   {
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(page-1)*rowSize;
	   List<MovieEntity> list=mService.movieListData(start);
	   int totalpage=mService.movieTotalPage();
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   /*
	    *   {
	    *     curpage:,
	    *     to...
	    *   }
	    */
	   
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   map.put("list", list);
	   return map;

   }
}