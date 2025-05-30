package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.MovieEntity;

public interface MovieService {
	List<MovieEntity> movieMainData();
	List<MovieEntity> movieListData(@Param("start") int start);
	public int movieTotalPage();
    public MovieEntity findById(@Param("id") int id);
}
