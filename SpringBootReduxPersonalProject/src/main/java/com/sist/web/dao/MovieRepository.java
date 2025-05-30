package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.MovieEntity;

import java.util.*;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{
    
    @Query(value = "SELECT * FROM movie_info WHERE LENGTH(poster) > 0 ORDER BY id ASC LIMIT 13", nativeQuery = true)
    List<MovieEntity> movieMainData();
    
    @Query(value="SELECT * "
        	  +"FROM movie_info "
        	  + "WHERE LENGTH(poster) > 0 "
        	  + "ORDER BY id ASC "
        	  +"LIMIT :start,16",nativeQuery = true)
    public List<MovieEntity> movieListData(@Param("start") int start);
    
    @Query(value="SELECT CEIL(COUNT(*)/16.0) FROM movie_info "
    		+ "WHERE LENGTH(poster) > 0",nativeQuery = true)
    public int movieTotalPage();
    
    
    // SELECT * FROM busan_food WHERE fno=?
    public MovieEntity findById(@Param("id") int id);
    
}









