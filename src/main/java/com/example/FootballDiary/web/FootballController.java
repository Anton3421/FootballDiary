package com.example.FootballDiary.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.FootballDiary.domain.Football;
import com.example.FootballDiary.domain.FootballRepository;



@Controller
public class FootballController {

	@Autowired
	private FootballRepository repository;
	

	//NÄYTÄ KAIKKI TREENIT
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	//NÄYTETÄÄN LISTA TREENEISTÄ FOOTBALL.HTML SIVULLA
	@RequestMapping(value="/footballlist", method=RequestMethod.GET)
	public String footballList(Model model) {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		model.addAttribute("name", username);
		model.addAttribute("footballs", repository.findAll());
		return "footballList";
	}
	//RESTful TREENILISTA
	@GetMapping(value = "/footballs")
	public @ResponseBody List<Football> footballListRest() {
		return (List<Football>) repository.findAll();
	}

	//RESTful TREENI ID
	@GetMapping(value="/football/{id}")
	public @ResponseBody Optional<Football> findfootballRest(@PathVariable("id") Long footballId) {
		return repository.findById(footballId);
	}
	//LISÄTÄÄN UUSI TREENI PÄIVÄKIRJAAN
	@GetMapping(value = "/add")
	public String addFootball(Model model) {
		model.addAttribute("football", new Football());
		return "addFootball";
	}
	//TALLENNETAAN TREENI REPOSITORYYN
	@PostMapping(value = "/save")
	public String save(Football football) {
		repository.save(football);
		return "redirect:/footballlist";
	}
	//POISTETAAN TREENI PÄIVÄKIRJASTA
	@GetMapping(value = "/delete/{id}")	
	public String deleteFootball(@PathVariable("id") Long footballId, Model model) {
		repository.deleteById(footballId);
		return "redirect:../footballlist";
	}
	//MUOKATAAN OLEMASSA OLEVAA TREENIÄ
	@GetMapping(value = "/edit/{id}")
	public String editFootball(@PathVariable("id") Long footballId, Model model) {
		model.addAttribute("football", repository.findById(footballId));
		return "editFootball";
	}
}