package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RatingController {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private RatingService ratingService;
	
	/**
     * Load all Rating
     * @param model current Model
     * @return itself update
     */
	
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
    	model.addAttribute("rating", ratingService.listRating());
        return "rating/list";
    }
    
    /**
     * Return add Rating list
     * @return itself update
     */
    
    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    /**
     * Use for validate a new RatingList
     * @return redirect to Rating Home if valid
     */
    
    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
    
    	if(!result.hasErrors()) {
    		ratingService.saveUpdate(rating);
        	model.addAttribute("rating", ratingService.listRating());
   		 	logger.info("Rating ajouté avec succès" + rating.toString());

    		return "redirect:/rating/list";
    	}
    	
    	return "rating/add";
    }
    
    /**
     * Use for navigate to the update form with the Rating asked
     * @return redirect to Rating update resource
     */

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	Rating rating = ratingService.findRatingById(id);
    	model.addAttribute("rating", rating);
    	return "rating/update";
    }
    
    /**
     * Use for update a bid and validate it
     * @return redirect to Rating Home if valid
     */

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "rating/update/"+id;
    	}
    	rating.setId(id);
    	ratingService.saveUpdate(rating);
    	model.addAttribute("rating", ratingService.listRating());
		logger.info("Rating modifié avec succès" + rating.toString());

    	return "redirect:/rating/list";
    }
    
    /**
     * Use for delete a bid
     * @return redirect to Rating Home
     */

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
    	Rating rating = ratingService.findRatingById(id);
    	ratingService.delete(rating);
    	model.addAttribute("rating", ratingService.listRating());
		logger.info("Rating supprimé avec succès" + rating.toString());

    	return "redirect:/rating/list";
    }
}
