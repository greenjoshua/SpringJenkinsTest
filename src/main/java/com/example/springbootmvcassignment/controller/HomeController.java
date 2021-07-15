package com.example.springbootmvcassignment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootmvcassignment.model.Country;
import com.example.springbootmvcassignment.service.CountryService;

@Controller
public class HomeController {
	@Autowired
	CountryService countService;
	
	@RequestMapping("/list_countries")
	public String listCountries(Model model) {
		List<Country> list = countService.getCountryList();
		model.addAttribute("countries", list);
		return "country"; // the view name
	}
	@RequestMapping("/country_details/{id}")
	public String countryDetails(@PathVariable(name="id") int id, Model model) {
		Country country = countService.getCountry(id);
		model.addAttribute("country", country);
		return "country_details";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCountryPage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_population");
		Country country = countService.get(id);
		mav.addObject("country", country);
		return mav;
	}
	
	@RequestMapping("/")
	public String welcome() {
		return null;
	}
	//Need to add validation to save page
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCountry(@Valid @ModelAttribute("country") Country count,
			BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "edit_population";
		} else {
			countService.saveCountry(count);
			return "redirect:/list_countries";
		}
	}
	@RequestMapping("/list_countries/new_country")
	public ModelAndView showCreateNewCountryPage() {
		ModelAndView mav = new ModelAndView("new_country");
		Country country = new Country();
		mav.addObject("country", country);
		return mav;
	}
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newCountry(@Valid @ModelAttribute("country") Country country,
			BindingResult bindingResult, Model model)
	{
		System.out.println(country);
		if (bindingResult.hasErrors()) {
			return "new_country";
		} else {
			//Country c = new Country();
			model.addAttribute("country",country);
			countService.saveCountry(country);
			return "redirect:/list_countries";
		}
	}
}
