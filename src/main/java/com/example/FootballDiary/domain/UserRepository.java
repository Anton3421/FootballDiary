package com.example.FootballDiary.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	//ETSITÄÄN KÄYTTÄJÄ KÄYTTÄJÄNIMEN KAUTTA
	User findByUsername(String username);
	//ETSITÄÄN KÄYTTÄJÄLISTALTA ROOLIN PERUSTEELLA
	List<User> findByRole(String role);
}
