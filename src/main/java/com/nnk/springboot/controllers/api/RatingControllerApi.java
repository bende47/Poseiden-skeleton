package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RatingControllerApi {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private RatingService ratingService;

	/**
	 * Use for validate a new RatingList
	 * 
	 * @return redirect to Rating Home if valid
	 */
	@PostMapping("/rating")
	public String validate(@RequestBody Rating rating) {
		ratingService.saveUpdate(rating);
		return "Rating ajouté avec succès";
	}

	/**
	 * Return add Rating list
	 * 
	 * @return itself update
	 */
	@GetMapping("/rating")
	public List<Rating> allRating() {
		return ratingService.listRating();
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Rating Home if valid
	 */
	@PutMapping("/rating/{id}")
	public String updateRating(@PathVariable("id") Integer id, @RequestBody Rating rating) {

		if (ratingService.findRatingById(id) == null) {
			return "Rating introuvable";
		} else {
			rating.setId(id);
			ratingService.saveUpdate(rating);
			return "Rating modifié avec succès";
		}
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Rating Home
	 */
	@DeleteMapping("/rating/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model) {
		Rating rating = ratingService.findRatingById(id);
		if (rating == null) {
			return "Rating introuvable";
		} else {
			ratingService.delete(rating);
			logger.info("Rating supprimé avec succès");

			return "Rating supprimé avec succès";
		}

	}
}
