package hn.com.practica.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.com.practica.domain.Price;
import hn.com.practica.domain.PriceResponse;
import hn.com.practica.repository.IPriceRepository;
import hn.com.practica.repository.IPriceResponseRepository;
import hn.com.practica.service.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService{

	
	@Autowired
	public IPriceRepository priceRepository;
	
	@Autowired
	public IPriceResponseRepository priceResponseRepository;
	
	@Override
	public List<Price> getAll() {
		return priceRepository.findAll();
	}

	@Override
	public List<Price> filterPrices(Date applicationDate, int productId, Long brandId) {
		return priceRepository.filterPrices(applicationDate,productId,brandId);
	}

	@Override
	public List<Price> filterPricesByBrandId(Long brandId) {
		return priceRepository.filterPricesByBrandId(brandId);
	}

	@Override
	public List<PriceResponse> filterPricesWithPojo(Date applicationDate, int productId, Long brandId) {
		return priceResponseRepository.filterPricesWithPojo(applicationDate, productId, brandId);
	}

}
