package com.example.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;
import com.example.demo.service.TripService;
import com.example.demo.util.Response;
import com.example.demo.util.ResponseView;
import com.example.demo.util.SessionTrip;

@Controller
@RequestMapping("/trip")
public class TopControllerView {

	@Autowired
	private TripService tripService;
	
	@Autowired
	SessionTrip sessionTrip;

	@GetMapping("/topView")
	public String index(Model model) {
		List<Integer> tripInfoList = tripService.getTripInfo();
		model.addAttribute("tripInfoList", tripInfoList);
		return "hello";
	}

	@GetMapping("/registerView")
	public String registerView(Model model) {
		List<Prefectures> prefecturesList = tripService.getAll();
		model.addAttribute("prefecturesList", prefecturesList);
		return "register";
	}
	
	@GetMapping("/registerListView")
	public String registerListView(Model model, @RequestParam int prefecturesId) {
		TripInfo tripInfo = new TripInfo(); 
		tripInfo.setPrefecturesId(prefecturesId);
		List<TripInfo> tripInfoList = tripService.searchById(tripInfo);
		model.addAttribute("tripInfoList", tripInfoList);
		return "registerList";
	}

	@GetMapping("/browseView")
	public String browseView(Model model, @RequestParam int tripId) {
		TripInfo tripInfo = new TripInfo(); 
		tripInfo.setTripId(tripId);
		TripInfo resTripInfo = tripService.searchByTripId(tripInfo);
		
		Prefectures prefuctures = new Prefectures();
		prefuctures.setPrefecturesId(resTripInfo.getPrefecturesId());
		Prefectures resPrefuctures = tripService.searchById(prefuctures);
		
		sessionTrip.getTripInfoBean().setTripId(tripId);
		sessionTrip.getTripInfoBean().setPrefecturesId(resTripInfo.getPrefecturesId());
		sessionTrip.getTripInfoBean().setPrefectures(resPrefuctures.getPrefectures());
		sessionTrip.getTripInfoBean().setLunchShopName(resTripInfo.getLunchShopName());
		sessionTrip.getTripInfoBean().setLunchInfo(resTripInfo.getLunchInfo());
		sessionTrip.getTripInfoBean().setDinnerShopName(resTripInfo.getDinnerShopName());
		sessionTrip.getTripInfoBean().setDinnerInfo(resTripInfo.getDinnerInfo());
		sessionTrip.getTripInfoBean().setBreakfastShopName(resTripInfo.getBreakfastShopName());
		sessionTrip.getTripInfoBean().setBreakfastInfo(resTripInfo.getBreakfastInfo());
		sessionTrip.getTripInfoBean().setAccommodationName(resTripInfo.getAccommodationName());
		sessionTrip.getTripInfoBean().setAccommodationInfo(resTripInfo.getAccommodationInfo());
		sessionTrip.getTripInfoBean().setTripStartDate(resTripInfo.getTripStartDate());
		sessionTrip.getTripInfoBean().setTripEndDate(resTripInfo.getTripEndDate());
		ResponseView responseView = new ResponseView();
		responseView.setTripInfoBean(sessionTrip.getTripInfoBean());

		model.addAttribute("responseView", responseView.getTripInfoBean());
		return "browse";
	}
	
	@GetMapping("editView")
	public String editView(Model model) {
		ResponseView responseView = new ResponseView();
		responseView.setTripInfoBean(sessionTrip.getTripInfoBean());
		
		List<Prefectures> prefecturesList = tripService.getAll();
		responseView.setPrefecturesList(prefecturesList);
		
		model.addAttribute("responseView", responseView.getTripInfoBean());
		model.addAttribute("prefecturesList", responseView.getPrefecturesList());
		return "edit";
		
	}
}