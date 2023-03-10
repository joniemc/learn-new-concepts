package hn.com.practica.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hn.com.practica.domain.PriceResponse;

@Repository
@Transactional
public interface IPriceResponseRepository extends JpaRepository<PriceResponse, Long>{
	
	@Query(value ="SELECT PRICE_RESPONSE.* \r\n"
			+ "FROM ( \r\n"
			+ "SELECT P.PRODUCT_ID,\r\n"
			+ "	P.BRAND_ID,\r\n"
			+ " B.BRAND_NAME,\r\n"
			+ "	P.PRICE_LIST,\r\n"
			+ "	CD.CATALOG_DETAIL_NAME as RATES,\r\n"
			+ "	FORMATDATETIME(P.START_DATE,'yyyy-MM-dd HH:mm:ss') as START_DATE,\r\n"
			+ "	FORMATDATETIME(P.END_DATE,'yyyy-MM-dd HH:mm:ss') as END_DATE,\r\n"
			+ "	P.PRICE,\r\n"
			+ "	P.CURR\r\n"
			+ "FROM PRICES AS P\r\n"
			+ "LEFT JOIN BRAND AS B\r\n"
			+ "ON P.BRAND_ID=B.BRAND_ID\r\n"
			+ "LEFT JOIN CATALOG_DETAIL AS CD\r\n"
			+ "ON P.PRICE_LIST=CD.CATALOG_DETAIL_ID\r\n"
			+ "WHERE FORMATDATETIME(:applicationDate,'yyyy-MM-dd HH:mm:ss') BETWEEN FORMATDATETIME(P.START_DATE,'yyyy-MM-dd HH:mm:ss') AND FORMATDATETIME(P.END_DATE,'yyyy-MM-dd HH:mm:ss')\r\n"
			+ "AND P.PRODUCT_ID=:productId\r\n"
			+ "AND P.BRAND_ID=:brandId\r\n"
			+ "ORDER BY P.PRIORITY DESC LIMIT 1\r\n"
			+ ") PRICE_RESPONSE;" , nativeQuery = true)
	List<PriceResponse> filterPricesWithPojo(@Param("applicationDate") Date applicationDate,@Param("productId") int productId, @Param("brandId") Long brandId);
	
}
