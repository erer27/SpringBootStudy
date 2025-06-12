package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.ProductEntity;


public interface ProductService {
	Map productMainData();
	public Map cosmeticsListData(@Param("start") int start,@Param("category") String category);
	public ProductEntity cosmeticsDetail(@Param("id") int id);
}