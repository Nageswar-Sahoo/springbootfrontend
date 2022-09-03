package com.howtodoinjava.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleRestController {

	@Value("${country}")
	private String value;

	@Value("${player_lives}")
	private String player_lives;
	@Value("${PROPERTIES_FILE_NAME}")
	private String PROPERTIES_FILE_NAME;
	@Value("${base_properties}")
	private String base_properties;


	@Value("${target_service}")
	private String targetUrl;
	
	@GetMapping("/example_service")
	public String example() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI(targetUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		return "After Rest Call "+ result.getBody();
	}

	public static void main(String[] args) {
		String text = "Lorem Ipsum is simply dummy text";
		String substring = text.substring(3);
		System.out.println(substring);
		System.out.println(substring.length());
		
		
		substring = text.substring(3, 10);
		System.out.println(substring);
		System.out.println(substring.length());
	}

}
