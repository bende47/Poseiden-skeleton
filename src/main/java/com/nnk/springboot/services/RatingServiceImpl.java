package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public void saveUpdate(Rating rating) {
		ratingRepository.save(rating);
	}

	@Override
	public void delete(Rating rating) {
		ratingRepository.delete(rating);		
	}

	@Override
	public List<Rating> listRating() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating findRatingById(int id) {
    	Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Rating Id:" + id));
    	return rating;
	}
	
}
