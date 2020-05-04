package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BildListServiceImpl implements BildListService{

	@Autowired 
	private BidListRepository bidListRepository;

	@Override
	public void saveUpdate(BidList bidList) {		
		bidListRepository.save(bidList);
	}

	@Override
	public void delete(BidList bidList) {
		bidListRepository.delete(bidList);
	}

	@Override
	public List<BidList> listBid() {
		return bidListRepository.findAll();
	}

	@Override
	public BidList findBidById(int id) {
		BidList bidList = bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid BidList Id:" + id));
		return bidList;
	}
	
	
	
	
}
