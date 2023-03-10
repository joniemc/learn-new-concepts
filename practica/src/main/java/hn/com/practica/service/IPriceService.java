package hn.com.practica.service;

import java.util.Date;
import java.util.List;

import hn.com.practica.domain.Price;
import hn.com.practica.domain.PriceResponse;


public interface IPriceService {
	public List<Price> getAll();
	public List<Price> filterPricesByBrandId(Long brandId);
	public List<Price> filterPrices(Date applicationDate, int productId, Long brandId);
	public List<PriceResponse> filterPricesWithPojo(Date applicationDate,int productId, Long brandId);
}
