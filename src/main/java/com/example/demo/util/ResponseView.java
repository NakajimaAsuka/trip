package com.example.demo.util;

import java.util.List;

import com.example.demo.entity.Prefectures;

public class ResponseView {
	
	private TripInfoBean tripInfoBean;
	
	private List<Prefectures> prefecturesList;

	public TripInfoBean getTripInfoBean() {
		return tripInfoBean;
	}

	public void setTripInfoBean(TripInfoBean tripInfoBean) {
		this.tripInfoBean = tripInfoBean;
	}

	public List<Prefectures> getPrefecturesList() {
		return prefecturesList;
	}

	public void setPrefecturesList(List<Prefectures> prefecturesList) {
		this.prefecturesList = prefecturesList;
	}
	
	
	
}
