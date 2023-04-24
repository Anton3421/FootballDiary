package com.example.FootballDiary;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.FootballDiary.domain.Football;
import com.example.FootballDiary.domain.FootballRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
@SpringBootTest(classes = FootballDiaryApplication.class)
public class FootballRepositoryTest {
	
	@Autowired
	private FootballRepository repository;
	
	@Test
	public void initialBooksAreReturned() {
		//TESTATAAN, LÖYTYYKÖ TREENI PÄIVÄLTÄ 24.05.2023
		List<Football> footballs = repository.findByDate("24.05.2023");
		
		//TESTATAAN, ONKO ENSIMMÄINEN TREENIN KUVAUS SAMA KUIN SHOOTING PRACTICE
		assertThat(footballs).hasSize(1);
		assertThat(footballs.get(0).getDescription()).isEqualTo("Shooting practice");
	}
	
	@Test 
	public void createNewFootball() {
		//LUODAAN UUSI TREENI
		Football football = new Football("05.06.2023", "2 h", "Endurance practice");
		repository.save(football);
		//TESTATAAN, ETTÄ TREENILLÄ ON ID
		assertThat(football.getId()).isNotNull();
	}
}
