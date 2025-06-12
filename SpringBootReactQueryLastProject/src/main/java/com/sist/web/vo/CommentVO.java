package com.sist.web.vo;

import java.util.Date;
// Entity : table을 제어 => column명외 다른 데이터를 사용할 수 없다 => insert
public interface CommentVO {
	  public int getNo();
	  public int getFno();
	  public String getId();
	  public String getName();
	  public String getMsg();
	  public String getDbday();
}