package hn.com.practica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hn.com.practica.domain.Price;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Long> {
	@Query(value = "SELECT * FROM PRICES WHERE BRAND_ID=:brandId", nativeQuery = true)
	List<Price> filterPricesByBrandId(@Param("brandId") Long brandId);

	@Query(value = "SELECT * " + "FROM PRICES "
			+ "WHERE FORMATDATETIME(:applicationDate,'yyyy-MM-dd HH:mm:ss') BETWEEN FORMATDATETIME(START_DATE,'yyyy-MM-dd HH:mm:ss') AND FORMATDATETIME(END_DATE,'yyyy-MM-dd HH:mm:ss') "
			+ "AND PRODUCT_ID=:productId " + "AND BRAND_ID=:brandId "
			+ "ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
	List<Price> filterPrices(@Param("applicationDate") Date applicationDate, @Param("productId") int productId,
			@Param("brandId") Long brandId);

}
