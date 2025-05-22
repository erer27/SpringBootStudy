package com.sist.web.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.Music;
/*
 * 		데이터베이스 ElasticSearch
 * 		----------------------
 * 		table	  index
 * 		column	  field
 * 		row		  document
 * 		----------------- NoSQL 기능 탑재 => 실시간 데이터
 * 		장점 => 클러스트 (리눅스 기반) => 하둡
 * 
 */
@Repository
public interface MusicRepository extends ElasticsearchRepository<Music, String>{
//	@Query("{\"query\":{\"match\":{\"title\":\"?0\"}}}")
	public List<Music> findByTitleContaining(String title);
}
