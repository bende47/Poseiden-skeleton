package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Rating;

public interface RatingService {
	/**
	 * 
	 *  @param Rating
	 */
	public void saveUpdate(Rating rating);
	
	/**
	 * 
	 * @param Rating
	 */
	public void delete(Rating rating);
	
	/**
	 * 
	 * @return list Rating
	 */
	public List<Rating> listRating();
	
	/**
	 * 
	 * @param id
	 * @return Rating
	 */
	public Rating findRatingById(int id);
}
