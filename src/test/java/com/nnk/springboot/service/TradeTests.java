package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;

	private Trade trade;

	@Before
	public void setup() {
		trade = new Trade("Trade Account", "Type", 10.0);
	}

	@Test
	public void saveTradeTest() {
		trade = tradeRepository.save(trade);
		Assert.assertNotNull(trade.getTradeId());
		Assert.assertTrue(trade.getAccount().equals("Trade Account"));
	}

	@Test
	public void updateTradeTest() {
		trade.setAccount("Trade Account Update");
		trade = tradeRepository.save(trade);
		Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));
	}
	
	@Test
	public void findTradeTest() {
		trade = tradeRepository.save(trade);
		Integer id = trade.getTradeId();
		Optional<Trade> tradeList = tradeRepository.findById(id);
		Assert.assertTrue(tradeList.isPresent());
	}

	@Test
	public void listTradeTest() {
		trade = tradeRepository.save(trade);
		List<Trade> listResult = tradeRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
	}

	@Test
	public void deleteTradeTest() {
		trade = tradeRepository.save(trade);
		Integer id = trade.getTradeId();
		tradeRepository.delete(trade);
		Optional<Trade> tradeList = tradeRepository.findById(id);
		Assert.assertFalse(tradeList.isPresent());
	}
}
