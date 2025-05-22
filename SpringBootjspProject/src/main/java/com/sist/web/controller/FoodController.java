package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
import com.sist.web.service.*;

@Controller
public class FoodController {
  @Autowired
  private FoodService fService;
  
  @GetMapping("/list")
  public String food_list(@RequestParam(name="page",required = false) String page,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  map.put("start", (curpage*10)-9);
	  map.put("end", curpage*10);
	  List<FoodVO> list=fService.foodListData(map);
	  int totalpage=fService.foodTotalPage();
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  return "list";
  }
  @GetMapping("/detail")
  public String food_detail(@RequestParam("fno") int fno,Model model)
  {
	  FoodVO vo=fService.FoodDetailData(fno);
	  model.addAttribute("vo", vo);
	  return "detail";
  }
}