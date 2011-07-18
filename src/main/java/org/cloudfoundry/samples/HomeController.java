package org.cloudfoundry.samples;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private ReferenceDataRepository referenceRepository;
	
	/**
	 * Prepares the Model with some metadata and the list of States retrieved
	 * from the DB. Then, selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("dbinfo", referenceRepository.getDbInfo());
		model.addAttribute("states", referenceRepository.findAll());
		return "home";
	}

	@RequestMapping(value="/check_out", method=RequestMethod.GET)
	public String check_out(Model model, 
			@RequestParam("user_email") String user_email, 
			@RequestParam("car_type") String car_type, 
			@RequestParam("destination") String destination){
		referenceRepository.insertCheckOutInfo(user_email, car_type, destination);
		model.addAttribute("user_email", user_email);
		model.addAttribute("car_type", car_type);
		model.addAttribute("destination", destination);
		model.addAttribute("trips", referenceRepository.findAllTrips());
		//referenceRepository.insertOne();
		return "check_out";
	}


	@RequestMapping(value="/check_in", method=RequestMethod.GET)
	public String check_in(Model model, 
			@RequestParam("user_email") String user_email){
		model.addAttribute("user_email", user_email);
		//referenceRepository.insertOne();
		return "check_in";
	}
	
	
	@RequestMapping(value="/in_out", method=RequestMethod.GET)
	public String param(Model model){
		return "in_out";
	}
}
