package com.example.demo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class SessionTrip implements Serializable{
	
	private static final long serialVersionID=1L;
	
	private TripInfoBean tripInfoBean;
	
	public TripInfoBean getTripInfoBean() {
		if(tripInfoBean == null) {
			tripInfoBean = new TripInfoBean();
		}
		return tripInfoBean;
	}
	
	public void setTripInfoBean(TripInfoBean tripInfoBean) {
		this.tripInfoBean = tripInfoBean;
	}
}
