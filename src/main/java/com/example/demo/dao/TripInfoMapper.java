package com.example.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;


@Mapper
public interface TripInfoMapper {
	boolean tripInfoSave(TripInfo tripInfo);
	
	boolean tripInfoUpdate(TripInfo tripInfo);
	
	boolean tripInfoDelete(TripInfo tripInfo);
	
	List<TripInfo> search();
	
	List<TripInfo> searchById(TripInfo tripInfo);
	
	TripInfo searchByTripId(TripInfo tripInfo);
	
}

