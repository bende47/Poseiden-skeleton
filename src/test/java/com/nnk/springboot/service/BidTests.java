package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
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
public class BidTests {

	@Autowired
	private BidListRepository bidListRepository;

	private  BidList bid;

	@Before
	public  void setup() {
		bid = new BidList("Account Test", "Type Test", 10d);
	}

	@Test
	public void savebidListTest() {
		// Save
		bid = bidListRepository.save(bid);
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);
	}

	@Test
	public void updatebidListTest() {
		bid.setBidQuantity(20d);
		bid = bidListRepository.save(bid);
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);
	}

	@Test
	public void findbidListTest() {
		bid = bidListRepository.save(bid);
		Integer id = bid.getBidListId();
		Optional<BidList> bidList = bidListRepository.findById(id);
		Assert.assertTrue(bidList.isPresent());
	}
	
	@Test
	public void bidListTest() {
		bid = bidListRepository.save(bid);
		List<BidList> listResult = bidListRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
	}
	
	@Test
	public void deletebidListTest() {
		bid = bidListRepository.save(bid);
		Integer id = bid.getBidListId();
		bidListRepository.delete(bid);
		Optional<BidList> bidList = bidListRepository.findById(id);
		Assert.assertFalse(bidList.isPresent());
	}
}
