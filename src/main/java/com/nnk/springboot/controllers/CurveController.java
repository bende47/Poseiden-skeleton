package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;

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

import java.util.Date;

import javax.validation.Valid;

@Controller
public class CurveController {

	private static final Logger logger = LogManager.getRootLogger();
	
	@Autowired
	private CurvePointService curvePointService;

	/**
     * Load all Curve Point
     * @param model current Model
     * @return itself update
     */
	
	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		model.addAttribute("curvepoint", curvePointService.listCurvePoint());
		return "curvePoint/list";
	}

	 /**
     * Return add Curve Point list
     * @return itself update
     */
	
	@GetMapping("/curvePoint/add")
	public String addBidForm(CurvePoint bid) {
		return "curvePoint/add";
	}

	 /**
     * Use for validate a new Curve Point
     * @return redirect to Curve Point Home if valid
     */
	
	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {

		if (!result.hasErrors()) {
			curvePoint.setCreationDate(new Date());
			curvePointService.saveUpdate(curvePoint);
			model.addAttribute("curvepoint", curvePointService.listCurvePoint());
   		 	logger.info("CurvePoint ajouté avec succès" + curvePoint.toString());

			return "redirect:/curvePoint/list";

		}
		return "curvePoint/add";
	}
	
	 /**
     * Use for navigate to the update form with the Curve Point asked
     * @return redirect to Curve Point update resource
     */

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		CurvePoint curvePoint = curvePointService.findCurvePointById(id);
		model.addAttribute("curvepoint", curvePoint);
		return "curvePoint/update";
	}
	
	/**
     * Use for update a bid and validate it
     * @return redirect to Curve Point Home if valid
     */

	@PostMapping("/curvePoint/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
            return "curvePoint/update/"+id;
        }
		
		curvePoint.setId(id);
		curvePoint.setAsOfDate(new Date());
		curvePointService.saveUpdate(curvePoint);
		model.addAttribute("curvepoint", curvePointService.listCurvePoint());
		logger.info("CurvePoint modifié avec succès" + curvePoint.toString());

		return "redirect:/curvePoint/list";
	}
	
	/**
     * Use for delete a bid
     * @return redirect to Curve Point Home
     */

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		CurvePoint curvePoint = curvePointService.findCurvePointById(id);
		curvePointService.delete(curvePoint);
		model.addAttribute("curvepoint", curvePointService.listCurvePoint());
		logger.info("CurvePoint supprimé avec succès" + curvePoint.toString());

		return "redirect:/curvePoint/list";
	}
}
