package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.ElasticBoardRepository;
import com.sist.web.vo.ElasticBoard;

@RestController
public class ElasticBoardRestController {
	@Autowired
	private ElasticBoardRepository bDao;
	
	@PostMapping("eboard/update_ok")
    public String eboard_update_ok(ElasticBoard vo,Model model)
    {
    	// id / name / subject / content / pwd => hit, regdate
    	String result="no";
    	ElasticBoard dbvo=bDao.findById(vo.getId());
    	if(dbvo.getPwd().equals(vo.getPwd()))
    	{
    		vo.setHit(dbvo.getHit());
    		vo.setRegdate(dbvo.getRegdate());
    		bDao.save(vo);//update
    		result="<script>"
    				+"location.href=\"/eboard/detail?id="+vo.getId()+"\""
    				+"</script>";
    	}
    	else
    	{
    		result="<script>"
    				+"alert(\"비밀번호가 틀립니다\");"
    				+"history.back();"
    				+"</script>";
    	}
    	
    	return "eboard/update_ok";
    }
	
	@PostMapping("/eboard/delete_ok")
	public String eboard_delete_ok(@RequestParam("id") int id,
			@RequestParam("pwd") String pwd)
	{
		String result="";
		ElasticBoard vo=bDao.findById(id);
		if(vo.getPwd().equals(pwd))
		{
			bDao.delete(vo);
			result="<script>"
					+"location.href=\"/eboard/list\""
    				+"</script>";
		}
		else
		{
			result="<script>"
    				+"alert(\"비밀번호가 틀립니다\");"
    				+"history.back();"
    				+"</script>";
		}
		return result;
	}
}
