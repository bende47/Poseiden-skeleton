package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService{
	
	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public void saveUpdate(Trade trade) {
		tradeRepository.save(trade);
	}

	@Override
	public void delete(Trade trade) {
		tradeRepository.delete(trade);		
	}

	@Override
	public List<Trade> listTrade() {
		return tradeRepository.findAll();
	}

	@Override
	public Trade findTradeById(int id) {
    	Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid BidList Id:" + id));
    	return trade;
	}
	
}
