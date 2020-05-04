package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BildListService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class BidListController {
	
	private static final Logger logger = LogManager.getRootLogger();
	
    @Autowired
    private BildListService bildListService;

    /**
     * Load all Bids
     * @param model current Model
     * @return itself update
     */
    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        model.addAttribute("bidlist",bildListService.listBid());
        return "bidList/list";
    }

    /**
     * Return add Bids list
     * @return itself update
     */
    
    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }
    
    /**
     * Use for validate a new BidList
     * @return redirect to Bid Home if valid
     */

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
    	 if (!result.hasErrors()) {            
    		 bildListService.saveUpdate(bid);   
             model.addAttribute("bidlist", bildListService.listBid());
    		 logger.info("BidList ajouté avec succès" + bid.toString());

    		 return "redirect:/bidList/list";
    	 }
    	
    	return "bidList/add";
    }
    
    /**
     * Use for navigate to the update form with the Bid asked
     * @return redirect to Bid update resource
     */

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	BidList bidList = bildListService.findBidById(id);
        model.addAttribute("bidList", bidList);
        return "bidList/update";
    }

    
    /**
     * Use for update a bid and validate it
     * @return redirect to Bid Home if valid
     */
    
    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "bidList/update/"+id;
        }
    	
    	bidList.setBidListId(id);
    	bildListService.saveUpdate(bidList);  
        model.addAttribute("bidlist", bildListService.listBid());
		logger.info("BidList modifié avec succès" + bidList.toString());

    	return "redirect:/bidList/list";
    }

    /**
     * Use for delete a bid
     * @return redirect to Bid Home
     */
    
    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
       BidList bidList = bildListService.findBidById(id);
       bildListService.delete(bidList);
       model.addAttribute("bidlist", bildListService.listBid());
       logger.info("BidList supprimé avec succès" + bidList.toString());

       return "redirect:/bidList/list";
    }
}
