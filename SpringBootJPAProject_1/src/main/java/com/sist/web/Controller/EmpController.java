package com.sist.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.dao.EmpRepository;
import com.sist.web.vo.Emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Controller
public class EmpController {
	@Autowired
	private EmpRepository eDao;
	
	@Autowired
	private EntityManager em;
	
	@GetMapping("/emp/list")
	public String emp_list(Model model)
	{
		List<Emp> list=eDao.empAllData();
		model.addAttribute("list",list);
		return "emp/list";
	}
	
	@GetMapping("/emp/detail")
	public String emp_detail(@RequestParam("empno") int empno,Model model)
	{
		String sql="SELECT s FROM Emp s JOIN s.dept d WHERE s.empno=:empno";
		Emp e=em.createQuery(sql,Emp.class).setParameter("empno", empno).getSingleResult();
//		Emp emp=eDao.findByEmpno(0);
		model.addAttribute("vo",e);
		return "emp/detail";
	}
	
	/*
	 * 		JPA
	 * 		 = 메소드 규칙
	 * 		 = @Query 사용법
	 * 		 = JOIN
	 * 
	 * 
	 */
	@GetMapping("emp.join")
	public String emp_join(Model model)
	{
		//JPQL구사
		String sql="SELECT s FROM Emp s JOIN Fetch s.dept";
		TypedQuery<Emp> query=em.createQuery(sql,Emp.class);
		List<Emp> list=query.getResultList();
		model.addAttribute("list",list);
		return "emp/join";
	}
}
