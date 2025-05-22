package com.sist.web.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Emp {
	@Id
	private int empno;
	private int sal;
	private String ename,job,mgr,hiredate,comm;
	
	@Column(insertable = false, updatable = false)
	private int deptno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deptno",referencedColumnName = "deptno")
	private Dept dept;
}
