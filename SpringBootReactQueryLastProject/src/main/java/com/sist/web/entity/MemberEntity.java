package com.sist.web.entity;
// react => 96% 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.*;
@Entity(name="member")
@Data
/*
 *  ID       NOT NULL VARCHAR2(20)  
	PWD      NOT NULL VARCHAR2(10)  
	NAME     NOT NULL VARCHAR2(50)  
	SEX               CHAR(6)       
	EMAIL             VARCHAR2(100) 
	BIRTHDAY NOT NULL DATE          
	ADDRESS  NOT NULL VARCHAR2(100) 
	REGDATE           DATE
 */
public class MemberEntity {
   @Id
   private String id;
   private String pwd,name,sex,email,address;
   private Date birthday,regdate;
}