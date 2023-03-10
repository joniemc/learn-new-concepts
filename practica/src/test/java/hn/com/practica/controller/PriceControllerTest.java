package hn.com.practica.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PriceControllerTest{

    @Autowired
    private MockMvc mockMvc;
	
	@Test
	@SqlGroup({
		@Sql({ "/schema.sql", "/data.sql" })
	})
	void filterPricesWithPojo() throws Exception{
		this.mockMvc.perform(get("/prices/v2/{applicationIdDate}/{productId}/{brandId}","2020-06-14 00:00:00",35455,1))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isArray())
         .andExpect(jsonPath("$.[0].productId").value(35455))
         .andExpect(jsonPath("$.[0].brandId").value(1))
         .andExpect(jsonPath("$.[0].brandName").value("ZARA"))
         .andExpect(jsonPath("$.[0].priceList").value(1))
         .andExpect(jsonPath("$.[0].rates").value("TARIFA #1"))
         .andExpect(jsonPath("$.[0].startDate").value("2020-06-14T06:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].endDate").value("2021-01-01T05:59:59.000+00:00"))
         .andExpect(jsonPath("$.[0].price").value(35.50))
         .andExpect(jsonPath("$.[0].curr").value("EUR"));
	}
	
	@Test
	@SqlGroup({
		@Sql({ "/schema.sql", "/data.sql" })
	})
	void filterPricesWithPojo2() throws Exception{
		this.mockMvc.perform(get("/prices/v2/{applicationIdDate}/{productId}/{brandId}","2020-06-14 16:00:00",35455,1))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isArray())
         .andExpect(jsonPath("$.[0].productId").value(35455))
         .andExpect(jsonPath("$.[0].brandId").value(1))
         .andExpect(jsonPath("$.[0].brandName").value("ZARA"))
         .andExpect(jsonPath("$.[0].priceList").value(2))
         .andExpect(jsonPath("$.[0].rates").value("TARIFA #2"))
         .andExpect(jsonPath("$.[0].startDate").value("2020-06-14T21:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].endDate").value("2020-06-15T00:30:00.000+00:00"))
         .andExpect(jsonPath("$.[0].price").value(25.45))
         .andExpect(jsonPath("$.[0].curr").value("EUR"));
	}
	
	@Test
	@SqlGroup({
		@Sql({ "/schema.sql", "/data.sql" })
	})
	void filterPricesWithPojo3() throws Exception{
		this.mockMvc.perform(get("/prices/v2/{applicationIdDate}/{productId}/{brandId}","2020-06-14 21:00:00",35455,1))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isArray())
         .andExpect(jsonPath("$.[0].productId").value(35455))
         .andExpect(jsonPath("$.[0].brandId").value(1))
         .andExpect(jsonPath("$.[0].brandName").value("ZARA"))
         .andExpect(jsonPath("$.[0].priceList").value(1))
         .andExpect(jsonPath("$.[0].rates").value("TARIFA #1"))
         .andExpect(jsonPath("$.[0].startDate").value("2020-06-14T06:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].endDate").value("2021-01-01T05:59:59.000+00:00"))
         .andExpect(jsonPath("$.[0].price").value(35.50))
         .andExpect(jsonPath("$.[0].curr").value("EUR"));
	}
	
	@Test
	@SqlGroup({
		@Sql({ "/schema.sql", "/data.sql" })
	})
	void filterPricesWithPojo4() throws Exception{
		this.mockMvc.perform(get("/prices/v2/{applicationIdDate}/{productId}/{brandId}","2020-06-15 10:00:00",35455,1))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isArray())
         .andExpect(jsonPath("$.[0].productId").value(35455))
         .andExpect(jsonPath("$.[0].brandId").value(1))
         .andExpect(jsonPath("$.[0].brandName").value("ZARA"))
         .andExpect(jsonPath("$.[0].priceList").value(3))
         .andExpect(jsonPath("$.[0].rates").value("TARIFA #3"))
         .andExpect(jsonPath("$.[0].startDate").value("2020-06-15T06:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].endDate").value("2020-06-15T17:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].price").value(30.50))
         .andExpect(jsonPath("$.[0].curr").value("EUR"));
	}
	void filterPricesWithPojo5() throws Exception{
		this.mockMvc.perform(get("/prices/v2/{applicationIdDate}/{productId}/{brandId}","2020-06-16 21:00:00",35455,1))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isArray())
         .andExpect(jsonPath("$.[0].productId").value(35455))
         .andExpect(jsonPath("$.[0].brandId").value(1))
         .andExpect(jsonPath("$.[0].brandName").value("ZARA"))
         .andExpect(jsonPath("$.[0].priceList").value(4))
         .andExpect(jsonPath("$.[0].rates").value("TARIFA #4"))
         .andExpect(jsonPath("$.[0].startDate").value("2020-06-15T22:00:00.000+00:00"))
         .andExpect(jsonPath("$.[0].endDate").value("2021-01-01T05:59:59.000+00:00"))
         .andExpect(jsonPath("$.[0].price").value(38.95))
         .andExpect(jsonPath("$.[0].curr").value("EUR"));
	}
}
