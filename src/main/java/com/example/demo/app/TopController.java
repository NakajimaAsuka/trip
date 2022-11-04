package com.example.demo.app;

import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Prefectures;
import com.example.demo.entity.TripInfo;
import com.example.demo.service.TripService;
import com.example.demo.util.Response;


import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.StorageService;

@RestController
@RequestMapping("/trip")
public class TopController {
	
	@Autowired
	private TripService tripService;
	
	private final StorageService storageService;

	@Autowired
	public TopController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@PostMapping("/register")
	public Response register(@RequestBody TripForm tripForm, Model model) throws ParseException {
		TripInfo tripInfo = new TripInfo();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		String status = null;
		tripInfo.setPrefecturesId(tripForm.getPrefecturesId());
		tripInfo.setAccommodationName(tripForm.getAccommodationName());
		tripInfo.setAccommodationInfo(tripForm.getAccommodationInfo());
		tripInfo.setBreakfastShopName(tripForm.getBreakfastShopName());
		tripInfo.setBreakfastInfo(tripForm.getBreakfastInfo());
		tripInfo.setLunchShopName(tripForm.getLunchShopName());
		tripInfo.setLunchInfo(tripForm.getLunchInfo());
		tripInfo.setDinnerShopName(tripForm.getDinnerShopName());
		tripInfo.setDinnerInfo(tripForm.getDinnerInfo());
		tripInfo.setTripStartDate(sdFormat.parse(tripForm.getTripStartDate()));
		tripInfo.setTripEndDate(sdFormat.parse(tripForm.getTripEndDate()));
		boolean isSaveResult = tripService.tripInfoSave(tripInfo);
		if(isSaveResult) {
			status = "OK";
		}else {
			status = "NG";
		}
		return new Response(status);
	}
	
	@PostMapping("/edit")
	public Response edit(@RequestBody TripForm tripForm, Model model) throws ParseException {
		TripInfo tripInfo = new TripInfo();
		String status = null;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		tripInfo.setTripId(tripForm.getTripId());
		tripInfo.setPrefecturesId(tripForm.getPrefecturesId());
		tripInfo.setAccommodationName(tripForm.getAccommodationName());
		tripInfo.setAccommodationInfo(tripForm.getAccommodationInfo());
		tripInfo.setBreakfastShopName(tripForm.getBreakfastShopName());
		tripInfo.setBreakfastInfo(tripForm.getBreakfastInfo());
		tripInfo.setLunchShopName(tripForm.getLunchShopName());
		tripInfo.setLunchInfo(tripForm.getLunchInfo());
		tripInfo.setDinnerShopName(tripForm.getDinnerShopName());
		tripInfo.setDinnerInfo(tripForm.getDinnerInfo());
		tripInfo.setTripStartDate(sdFormat.parse(tripForm.getTripStartDate()));
		tripInfo.setTripEndDate(sdFormat.parse(tripForm.getTripEndDate()));
		boolean isSaveResult = tripService.tripInfoUpdate(tripInfo);
		if(isSaveResult) {
			status = "OK";
		}else {
			status = "NG";
		}
		return new Response(status);
	}
	
	@PostMapping("delete")
	public Response delete(@RequestParam int tripId) {
		TripInfo tripInfo = new TripInfo();
		String status = null;
		
		tripInfo.setTripId(tripId);
		boolean isDeleteResult = tripService.tripInfoDelete(tripInfo);
		if(isDeleteResult) {
			status = "OK";
		}else {
			status = "NG";
		}
		return new Response(status);
	}
	

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(TopController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}
}