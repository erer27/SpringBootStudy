package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.ProductEntity;
import com.sist.web.service.*;
import java.util.*;

import javax.management.loading.MLet;
@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
   @Autowired
   private ProductService pService;
   
   @GetMapping("/main")
   public ResponseEntity<Map> main_data()
   {
	   Map mlist = null;
	   try
	   {
		   mlist = pService.productMainData();
		   
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(mlist,HttpStatus.OK);
   }
   
   @GetMapping("/cosmetics/list/{page}/{category}")
   public ResponseEntity<Map> cosmeticsList(@PathVariable("page") int page,@PathVariable("category") String category)
   {
	   Map map = null;
	   try
	   {
		   map = pService.cosmeticsListData(page,category);
		   
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
   
   @GetMapping("/cosmetics/detail/{id}")
   public ResponseEntity<Map> cosmeticsDetail(@PathVariable("id") int id)
   {
	   System.out.println(id);
	   Map map = new HashMap();
	   try
	   {
		   ProductEntity pe = pService.cosmeticsDetail(id);
		   map.put("cosmetics", pe);
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
   }
}