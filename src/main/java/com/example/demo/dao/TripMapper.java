package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;

@Mapper
public interface TripMapper {
	
	List<Prefectures> search();
	
	Prefectures searchById(Prefectures prefuctures);
}

