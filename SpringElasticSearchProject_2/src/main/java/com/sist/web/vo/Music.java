package com.sist.web.vo;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(indexName = "music")
@Data
public class Music {
	@Id
	private String id;
	private String title;
	private String singer;
	private String album;
	private String poster;
	private String state;
	private Integer idcrement;
}
