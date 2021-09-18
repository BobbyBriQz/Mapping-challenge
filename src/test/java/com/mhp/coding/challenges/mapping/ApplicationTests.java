package com.mhp.coding.challenges.mapping;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testControllers() {
		assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/article",
				List.class).size() > 0);
		assertNotNull(this.restTemplate.getForObject("http://localhost:" + port + "/article/1001",
				ArticleDto.class));
		ArticleDto articleDto = new ArticleDto();
		assertNotNull(this.restTemplate.postForEntity("http://localhost:" + port + "/article",
				articleDto, ArticleDto.class));
	}

	@Test
	public void contextLoads() {
	}

}
