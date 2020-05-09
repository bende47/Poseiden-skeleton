package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;


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
public class RuleNameControllerApi {

	@Autowired
	private RuleNameService ruleNameService;

	/**
	 * Use for validate a new RuleList
	 * 
	 * @return redirect to Rule Home if valid
	 */
	@PostMapping("/ruleName")
	public String validate(@RequestBody RuleName ruleName) {
		ruleNameService.saveUpdate(ruleName);
		return "RuleName ajouté avec succè";
	}

	
	/**
	 * Use for navigate to the update form with the Rule asked
	 * 
	 * @return redirect to Rule update resource
	 */
	@GetMapping("/ruleName")
	public List<RuleName> allRuleName() {
		return ruleNameService.listRuleName();
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Rule Home if valid
	 */
	@PutMapping("/ruleName/{id}")
	public String updateRuleName(@PathVariable("id") Integer id, @RequestBody RuleName ruleName) {
		
		if(ruleNameService.findRuleNameById(id)==null) {
			return "RuleName introuvable";
		}else {
			ruleName.setId(id);
			ruleNameService.saveUpdate(ruleName);
			return "RuleName modifié avec succès";
		}
		
		
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Rule Home
	 */
	@DeleteMapping("/ruleName/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id) {

		RuleName ruleName = ruleNameService.findRuleNameById(id);
		if(ruleName==null) {
			return "RuleName introuvable";
		}else {
			ruleNameService.delete(ruleName);		
			return "RuleName supprimé avec succès";
		}
		
	}
}
