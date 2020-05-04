package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.BidList;

public interface BildListService {

	/**
	 * 
	 *  @param bidList
	 */
	public void saveUpdate(BidList bidList);
	
	/**
	 * 
	 * @param bidList
	 */
	public void delete(BidList bidList);
	
	/**
	 * 
	 * @return list Bid
	 */
	public List<BidList> listBid();
	
	/**
	 * 
	 * @param id
	 * @return BidList
	 */
	public BidList findBidById(int id);
	
}
