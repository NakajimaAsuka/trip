package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.MapKey;

import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;

public interface TripService {
	List<Prefectures> getAll();
	
	Prefectures searchById(Prefectures prefectures);
	
	List<Integer> getTripInfo();
	
	boolean tripInfoSave(TripInfo tripInfo); 
	
	boolean tripInfoUpdate(TripInfo tripInfo);
	
	boolean tripInfoDelete(TripInfo tripInfo);
	
	List<TripInfo> searchById(TripInfo tripInfo);
	
	TripInfo searchByTripId(TripInfo tripInfo);
}
