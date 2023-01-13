package pet.project.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pet.project.calendar.entity.*;
import pet.project.calendar.repository.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CalendarApplication {

	private static final Logger log = LoggerFactory.getLogger(CalendarApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {

	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry
	// 				.addMapping("/entity-management/workspaces")
	// 				.allowedOrigins("http://localhost:5173");
	// 		}
	// 	};
	// }
}
