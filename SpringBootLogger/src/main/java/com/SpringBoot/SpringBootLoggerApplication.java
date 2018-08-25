package com.SpringBoot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLoggerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoggerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggerApplication.class, args);
	
	
		LOGGER.error("Message logged at ERROR level");
		LOGGER.warn("Message logged at WARN level");
		LOGGER.info("Message logged at INFO level");
		LOGGER.debug("Message logged at DEBUG level");
	
	
	
	}
	
	@GetMapping("/")
	public String welcome()
	{
		String str = "hi";
		if(str.length() == 2)
		{
			 throw new RuntimeException("SOME EXCEPTION OCCURES");
		}
		return "welcome";
	}
}
