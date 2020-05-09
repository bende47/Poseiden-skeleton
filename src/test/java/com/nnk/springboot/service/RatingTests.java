package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingTests {

	@Autowired
	private RatingRepository ratingRepository;

	private Rating rating;
	
	@Before
	public void setup() {
		rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
	}
	
	@Test
	public void saveRatingTest() {
		rating = ratingRepository.save(rating);
		Assert.assertNotNull(rating.getId());
		Assert.assertTrue(rating.getOrderNumber() == 10);
	}

	@Test
	public void updateRatingTest() {
		rating.setOrderNumber(20);
		rating = ratingRepository.save(rating);
		Assert.assertTrue(rating.getOrderNumber() == 20);
	}
	
	@Test
	public void findRatingTest() {
		rating = ratingRepository.save(rating);
		Integer id = rating.getId();
		Optional<Rating> ratingList = ratingRepository.findById(id);
		Assert.assertTrue(ratingList.isPresent());
	}

	@Test
	public void ListRatingTest() {
		rating = ratingRepository.save(rating);
		List<Rating> listResult = ratingRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
	}

	@Test
	public void deleteRatingTest() {
		rating = ratingRepository.save(rating);
		Integer id = rating.getId();
		ratingRepository.delete(rating);
		Optional<Rating> ratingList = ratingRepository.findById(id);
		Assert.assertFalse(ratingList.isPresent());
	}
}
