package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradeControllerApi {


	@Autowired
	private TradeService tradeService;	


	/**
	 * Use for validate a new TradeList
	 * 
	 * @return redirect to Trade Home if valid
	 */
	@PostMapping("/trade")
	public String validate(@RequestBody Trade trade) {
		tradeService.saveUpdate(trade);
		return "Trade ajouté avec succès";
	}
	

	/**
	 * Return add Trade list
	 * 
	 * @return itself update
	 */
	@GetMapping("/trade")
	public List<Trade> allTrade (Trade bid) {
		return tradeService.listTrade();
	}
	
		
	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Trade Home if valid
	 */
	@PutMapping("/trade/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @RequestBody Trade trade) {
		if(tradeService.findTradeById(id)==null) {
			return "trade introuvable";
		}else {
			trade.setTradeId(id);
			tradeService.saveUpdate(trade);
			return "Trade modifié avec succès";
		}		
		
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Trade Home
	 */
	@DeleteMapping("/trade/{id}")
	public String deleteTrade(@PathVariable("id") Integer id) {
		
		Trade trade = tradeService.findTradeById(id);
		if(trade==null) {
			return "trade introuvable";
		}else {
			tradeService.delete(trade);
			return "Trade supprimé avec succès";	
		}		
		
	}
}
