package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.MovieRepository;
import com.sist.web.entity.MovieEntity;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository dao;

	@Override
	public List<MovieEntity> movieMainData() {
		// TODO Auto-generated method stub
		return dao.movieMainData();
	}

	@Override
	public List<MovieEntity> movieListData(int start) {
		// TODO Auto-generated method stub
		return dao.movieListData(start);
	}

	@Override
	public int movieTotalPage() {
		// TODO Auto-generated method stub
		return dao.movieTotalPage();
	}

	@Override
	public MovieEntity findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
