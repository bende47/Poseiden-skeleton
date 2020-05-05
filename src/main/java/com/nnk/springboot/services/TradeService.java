package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Trade;

public interface TradeService {
	/**
	 * 
	 *  @param Trade
	 */
	public void saveUpdate(Trade trade);
	
	/**
	 * 
	 * @param Trade
	 */
	public void delete(Trade trade);
	
	/**
	 * 
	 * @return list Trade
	 */
	public List<Trade> listTrade();
	
	/**
	 * 
	 * @param id
	 * @return Trade
	 */
	public Trade findTradeById(int id);
}
