package vttp2023.assessment.paf.batch3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2023.assessment.paf.batch3.models.Style;


@Controller
@RequestMapping
public class BeerController {



	
	
	
	//TODO Task 2 - view 0

	//Find the distinct number of styles of beer using distinct query in MySQL workbench
	//Link 
	@Autowired
	Style s;

	@Bean
	@GetMapping(path="/")
	
	public String landingPage(ModelMap model) {
		model.addAttribute("name", s.getName());
		model.addAttribute("beerCount",s.getBeerCount());
		return "view0";

	}
	//TODO Task 3 - view 1
	

	//TODO Task 4 - view 2

	
	//TODO Task 5 - view 2, place order

}

