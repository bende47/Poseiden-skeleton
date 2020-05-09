package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BildListService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class BidListControllerApi {


	@Autowired
	private BildListService bildListService;

	/**
	 * Use for validate a new BidList
	 * 
	 * @return redirect to Bid Home if valid
	 */
	@PostMapping("/bidList")
    public String validate(@RequestBody BidList bid) {	
		bildListService.saveUpdate(bid);
		return "BidList ajouté avec succès";
	}
	
	/**
     * Return add Bids list
     * @return itself update
     */    
    @GetMapping("/bidList")
    public List<BidList> allBid() {
		return bildListService.listBid();
    }
	

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Bid Home if valid
	 */
	@PutMapping("/bidList/{id}")
	public String updateBid(@PathVariable("id") Integer id, @RequestBody BidList bidList) {

		if (bildListService.findBidById(id) == null) {
			return "BidList introuvavle";
		} else {
			bidList.setBidListId(id);
			bildListService.saveUpdate(bidList);
			return "BidList modifié avec succès";
		}

	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Bid Home
	 */
	@DeleteMapping("/bidList/{id}")
	public String deleteBid(@PathVariable("id") Integer id) {

		BidList bidList = bildListService.findBidById(id);

		if (bidList == null) {
			return "BidList introuvavle";
		} else {
			bildListService.delete(bidList);
			return "BidList supprimé avec succès";
		}

	}
}
