package hn.com.practica;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.google.gson.Gson;

import hn.com.practica.repository.IPriceRepository;

@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@Sql({ "/schema.sql", "/data.sql" })
class PracticaApplicationTests {

	@Autowired
	public IPriceRepository repository;
	
	@Value("${test.name}")
	private String name;
	
	@Test
	void contextLoads() {
		Gson gson = new Gson();
		System.out.println(name);
		System.out.println(gson.toJson(repository.findAll()));
		
	}

}
