package com.example.FootballDiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.FootballDiary.domain.Football;
import com.example.FootballDiary.domain.FootballRepository;

import com.example.FootballDiary.domain.User;
import com.example.FootballDiary.domain.UserRepository;

@SpringBootApplication
public class FootballDiaryApplication {
	private static final Logger log = LoggerFactory.getLogger(FootballDiaryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FootballDiaryApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(FootballRepository repository, UserRepository urepository) {
		return (args) -> {

			// LUODAAN UUSIA TREENEJÄ JA TALLENNETAAN NE REPOSITORYYN
			Football football = new Football("24.05.2023", "1.5 h", "Shooting practice");
			repository.save(football);
			football = new Football("25.05.2023", "1 h", "Basic practice");
			repository.save(football);
			// LUODAAN UUSIA KÄYTTÄJIÄ JA TALLENETAAN NE REPOSITORYYN
			User user1 = new User("user", "USER", "$2a$10$sTaVf9alFVduKKeoj5d3ie.fO9UJET1FVQ0H1vRSKxxtN215C8y7u",
					"user@gmail.com");
			User user2 = new User("admin", "ADMIN", "$2a$10$U0F0R3/Iczfxo8.D5csAde8phvS9j3PJoOOZIs2QV.MJ5cGLM3bk6",
					"admin@gmail.com");
			urepository.save(user1);
			urepository.save(user2);

		};
	}

}
