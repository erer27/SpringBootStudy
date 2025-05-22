package com.sist.web.vo;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "busaninfo")

@Getter
@Setter
public class BusanInfoEntity {
	  @Id
	  private int id;
	  private int cno;
	  private String title,poster,address,phone,info;
}
