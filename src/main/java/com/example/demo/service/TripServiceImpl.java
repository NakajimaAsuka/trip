package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import com.example.demo.dao.TripMapper;
import com.example.demo.dao.TripInfoMapper;
import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;

@Service
public class TripServiceImpl implements TripService {
	@Autowired
	private TripMapper tripMapper;
	
	@Autowired
	private TripInfoMapper tripInfoMapper;

	@Override
	public List<Prefectures> getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return tripMapper.search();
	}

	@Override
	public List<Integer> getTripInfo() {
		List<TripInfo> tripInfoList = tripInfoMapper.search();
		//Map<String, Boolean> map = new HashMap<>();
		List<Integer> aaa = new ArrayList<>();
		for(TripInfo tripInfo : tripInfoList) {
			aaa.add(tripInfo.getPrefecturesId());
		}
		return aaa;
	}
	public boolean tripInfoSave(TripInfo tripInfo) {
		return tripInfoMapper.tripInfoSave(tripInfo);
	}

	@Override
	public List<TripInfo> searchById(TripInfo tripInfo) {
		return tripInfoMapper.searchById(tripInfo);
	}

	@Override
	public TripInfo searchByTripId(TripInfo tripInfo) {
		return tripInfoMapper.searchByTripId(tripInfo);
	}

	@Override
	public Prefectures searchById(Prefectures prefectures) {
		return tripMapper.searchById(prefectures);
	}

	@Override
	public boolean tripInfoUpdate(TripInfo tripInfo) {
		return tripInfoMapper.tripInfoUpdate(tripInfo);
	}

	@Override
	public boolean tripInfoDelete(TripInfo tripInfo) {
		return tripInfoMapper.tripInfoDelete(tripInfo);
	}

}
