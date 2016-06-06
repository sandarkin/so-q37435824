package com.sandarkin.so.q37435824;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
@TestExecutionListeners(inheritListeners = false, listeners = {
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class})
public class ApplicationTests extends AbstractTestNGSpringContextTests {

	@Value("${local.server.port}")
	private int port = 0;

	@Value("${security.user.name}")
	private String username;

	@Value("${security.user.password}")
	private String password;

	@Test
	public void checkAllowable() {
		ResponseEntity<String> entity = new TestRestTemplate(this.username, this.password)
				.getForEntity("http://localhost:" + port + "/something/1", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void checkForbidden() {
		ResponseEntity<String> entity = new TestRestTemplate(this.username, this.password)
				.getForEntity("http://localhost:" + port + "/something/2", String.class);
		assertEquals(HttpStatus.FORBIDDEN, entity.getStatusCode());
	}

}
