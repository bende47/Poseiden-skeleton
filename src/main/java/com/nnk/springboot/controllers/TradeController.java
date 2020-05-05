package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;

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
public class TradeController {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private TradeService tradeService;

	/**
	 * Load all Trade
	 * 
	 * @param model current Model
	 * @return itself update
	 */
	@RequestMapping("/trade/list")
	public String home(Model model) {
		logger.info("Request = @RequestMapping(\"/trade/list\")");
		model.addAttribute("trade", tradeService.listTrade());
		return "trade/list";
	}

	/**
	 * Return add Trade list
	 * 
	 * @return itself update
	 */
	@GetMapping("/trade/add")
	public String addUser(Trade bid) {
		logger.info("Request = @GetMapping(\"/trade/add\")");
		return "trade/add";
	}

	/**
	 * Use for validate a new TradeList
	 * 
	 * @return redirect to Trade Home if valid
	 */
	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult result, Model model) {
		logger.info("Request = @PostMapping(\"/trade/validate\" + @RequestBody = {}", trade + ")");

		if (!result.hasErrors()) {
			tradeService.saveUpdate(trade);
			model.addAttribute("trade", tradeService.listTrade());
			logger.info("Trade ajouté avec succès");

			return "redirect:/trade/list";

		}

		return "trade/add";
	}

	/**
	 * Use for navigate to the update form with the Trade asked
	 * 
	 * @return redirect to Trade update resource
	 */
	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/trade/update/" + id + "\")");
		Trade trade = tradeService.findTradeById(id);
		model.addAttribute("trade", trade);
		return "trade/update";
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Trade Home if valid
	 */
	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
		logger.info("Request = @PostMapping(\"/trade/update/" + id + "\" + @RequestBody = {}", trade + ")");

		if (result.hasErrors()) {
			return "/trade/update/" + id;
		}
		trade.setTradeId(id);
		tradeService.saveUpdate(trade);
		model.addAttribute("trade", tradeService.listTrade());
		logger.info("Trade modifié avec succès");

		return "redirect:/trade/list";
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Trade Home
	 */
	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/trade/delete/" + id + "\")");
		Trade trade = tradeService.findTradeById(id);
		tradeService.delete(trade);
		model.addAttribute("trade", tradeService.listTrade());
		logger.info("Trade supprimé avec succès");

		return "redirect:/trade/list";
	}
}
