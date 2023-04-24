package com.example.FootballDiary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.FootballDiary.web.FootballController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private FootballController controller;
	
	@Test
	//TESTATAAN, ETTEI CONTROLLERISTA PALAUDU ARVOA NULL
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		
	}

}
