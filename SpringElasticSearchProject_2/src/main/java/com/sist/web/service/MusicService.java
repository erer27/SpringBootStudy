package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
import java.util.*;
@Service
public class MusicService {
	@Autowired
	private MusicRepository mRepository;
	
	public void saveMusic(Music music)
	{
		mRepository.save(music);
	}
	public Music getMusicId(String id)
	{
		return mRepository.findById(id).orElse(null);
	}
	public List<Music> getMusicFind(String title)
	{
		return mRepository.findByTitleContaining(title);
	}
	public List<Music> musicFindData(String title)
	{
		List<Music> list=new ArrayList<Music>();
		return list;
	}
	public List<Music> getAllMusics(int page)
	{
		int rowSize=12;
		Pageable pg=PageRequest.of(page-1, rowSize);
		Page<Music> pList=mRepository.findAll(pg);
		List<Music> list=new ArrayList<Music>();
		if(pList!=null && pList.hasContent())
		{
			list=pList.getContent();
		}
		return list;
				
	}
	public int getTotalPage()
	{
		int count=(int)mRepository.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		return totalpage;
	}
	
	public Page<Music> getId(int page)
	{
		int rowSize=12;
		Pageable pg=PageRequest.of(page-1, rowSize,Sort.by(Sort.Direction.ASC,"id"));
		return mRepository.findAll(pg);
				
	}
	
}
