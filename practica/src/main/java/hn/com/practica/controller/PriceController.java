package hn.com.practica.controller;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hn.com.practica.service.IPriceService;

@RestController
public class PriceController {
	@Autowired IPriceService priceService;
	
	ResponseEntity<?> response = null;
	
	@GetMapping("/prices")
	public @ResponseBody ResponseEntity<?> getPrices() {
	
		response = null;
		
		try {
			response = new ResponseEntity<>(priceService.getAll(), HttpStatus.OK);
		}catch(Exception ex) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping("/prices/v1/{applicationIdDate}/{productId}/{brandId}")
	public @ResponseBody ResponseEntity<?> filterPrices(@PathVariable("applicationIdDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date applicationDate, 
			@PathVariable("productId") int productId, @PathVariable("brandId") Long brandId) {
		
		response = null;
		
		try {
			response = new ResponseEntity<>(priceService.filterPrices(applicationDate,productId,brandId), HttpStatus.OK);
		}catch(Exception ex) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping("/prices/v2/{applicationIdDate}/{productId}/{brandId}")
	public @ResponseBody ResponseEntity<?> filterPricesWithPojo(
			@PathVariable("applicationIdDate") 
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
			Date applicationDate, 
			@PathVariable("productId") int productId, @PathVariable("brandId") Long brandId) {
		
		response = null;
		
		try {
			response = new ResponseEntity<>(priceService.filterPricesWithPojo(applicationDate,productId,brandId), HttpStatus.OK);
		}catch(Exception ex) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
