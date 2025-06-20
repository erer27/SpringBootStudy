package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import com.sist.web.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;
@RestController
// => Restful => GET(읽기) SELECT , POST(쓰기) INSERT , PUT(수정) UPDATE , DELETE(삭제)
@CrossOrigin(origins = "*") // 모든 port 허용 
// 1521 / 8080 => aws는 0~1023까지 port를 접근 거부 
public class BoardRestController {
   @Autowired
   private BoardRepository bDao;
   // http://localhost/board/list_react/${page}
   // ResponseEntity<Map> 
   @GetMapping("/board/list/{page}")
   public Map board_list(@PathVariable("page") int page)
   {
	   // 2025-05-21 00:00:00
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(page-1)*rowSize;
	   List<BoardEntity> list=bDao.boardListData(start);
	   for(BoardEntity vo:list)
	   {
		   String day=vo.getRegdate();
		   day=day.substring(0,day.indexOf(" "));
		   vo.setRegdate(day.trim());
	   }
	   int count=(int)bDao.count();
	   int totalpage=(int)(Math.ceil(count/(double)rowSize));
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   
	   map.put("today", today);
	   map.put("curpage",page);
	   map.put("totalpage", totalpage);
	   map.put("list", list);
	   
	   return map;
   }
   @PostMapping("/board/insert")
   public Map board_insert(@RequestBody BoardEntity vo)
   {
	   Map map=new HashMap();
	   try
	   {
	     vo.setHit(0);
	     BoardEntity _vo=bDao.save(vo);
	     map.put("vo", _vo);
	     map.put("msg", "yes");
	   }catch(Exception ex)
	   {
		   map.put("msg", ex.getMessage());
	   }
	   return map;
   }
   /*
    *    JPA => DataSet => VO를 가지고 데이터베이스 제어 
    *             |
    *           SQL없이 사용이 가능 
    *    => 복잡한 쿼리 , WHERE (조건문) => 규칙 
    *       find    By     No(int no)  WHERE no=?
    *       SELECT  WHERE  Column
    *       SELECT DISTINCT ~
    *       findDistinctBy
    *    => 나머지는 제공하는 메소드 사용 
    *       = count() SELECT COUNT(*) ~
    *       = save() => insert/update 
    *       = delete() 
    */
   @GetMapping("/board/detail/{no}")
   public BoardEntity board_detail(@PathVariable("no") int no)
   {
	   BoardEntity vo=bDao.findByNo(no);
	   ///// 조회수 증가 
	   vo.setHit(vo.getHit()+1);
	   bDao.save(vo);
	   vo=bDao.findByNo(no);
	   return vo;
   }
   // 삭제
   @DeleteMapping("/board/delete/{no}/{pwd}")
   public Map board_delete(@PathVariable("no") int no,@PathVariable("pwd") String pwd)
   {
	   Map map=new HashMap();
	   BoardEntity vo=bDao.findByNo(no);
	   if(pwd.equals(vo.getPwd()))
	   {
		   bDao.delete(vo);
		   map.put("msg", "yes");
	   }
	   else
	   {
		   map.put("msg", "no");
	   }
	   return map;
   }
   @GetMapping("/board/update/{no}")
   public BoardEntity board_update(@PathVariable("no") int no)
   {
	   
	   BoardEntity vo=bDao.findByNo(no);
	   
	   return vo;
   }
   /*
    *      @Id
		   private int no; ========> insert,update = true
		   private String name;====> insert,update = true
		   private String subject;===> insert,update = true
		   private String content;===>  insert,update = true
		   
		   @Column(insertable = true , updatable = false)
		   private String pwd; ===>
		   
		   @Column(insertable = true , updatable = false)
		   
		   private String regdate;
		   private int hit; ===>  insert,update = true
    */
   @PutMapping("/board/update_ok")
   public Map board_update_ok(@RequestBody BoardEntity vo)
   {
	   Map map=new HashMap();
	   BoardEntity db=bDao.findByNo(vo.getNo());
	   if(vo.getPwd().equals(db.getPwd()))
	   {
		   vo.setNo(vo.getNo());
		   vo.setHit(db.getHit());
		   bDao.save(vo); 
		   map.put("msg","yes");
	   }
	   else
	   {
		   map.put("msg", "no");
	   }
	   return map;
   }
   
}