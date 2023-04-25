package com.example.FootballDiary.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FootballRepository extends CrudRepository<Football, Long> {
	// ETSITÄÄN TREENI PÄIVÄMÄÄRÄN MUKAAN LISTALTA
	List<Football> findByDate(String Date);
}
