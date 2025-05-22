package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardVO;

import java.util.*;
/*
 * 		Controller 동일
 * 		DAO / Service : 오라클 (MyBatis) MySQL(JPA) , ElasticSearch
 * 		Front-End : JSP / ThymeLeaf , Vue , React
 * 		
 * 		@Query
 * 		JOIN / CRUD 
 */
public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{
	// findAll()
	// SELECT b FROM BoardEntity b
	@Query(value="SELECT no,subject,name,regdate,hit "
			+ "FROM board ORDER BY no DESC "
			+ "LIMIT :start,10",nativeQuery = true)
//	@Query("SELECT b FROM BoardEntity b ")
	// ?  #{start}  : start  :end
	public List<BoardVO> boardListData(@Param("start") int start);
	// public Page<BoardVO> findAll(Pageable pg)
	
	// 상세보기
	public BoardEntity findByNo(@Param("no") Integer no);
	
	// 검색
	public List<BoardEntity> findByNameContaining(@Param("name") String name);
	public List<BoardEntity> findBySubjectContaining(@Param("subject") String subject);
	public List<BoardEntity> findContentContaining(@Param("content") String content);
	
	// JPA => JOIN(O) , SubQuery(X)
	// MyBatis 
	// count() save():INSERT,UPDATE delete() => SELECT => WHERE
}
