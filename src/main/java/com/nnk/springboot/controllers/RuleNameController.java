package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;

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
public class RuleNameController {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private RuleNameService ruleNameService;

	/**
	 * Load all Rule
	 * 
	 * @param model current Model
	 * @return itself update
	 */
	@RequestMapping("/ruleName/list")
	public String home(Model model) {
		logger.info("Request = @RequestMapping(\"/ruleName/list\")");
		model.addAttribute("rulename", ruleNameService.listRuleName());
		return "ruleName/list";
	}

	/**
	 * Return add Rule list
	 * 
	 * @return itself update
	 */
	@GetMapping("/ruleName/add")
	public String addRuleForm(RuleName bid) {
		logger.info("Request = @GetMapping(\"/ruleName/add\")");
		return "ruleName/add";
	}

	/**
	 * Use for validate a new RuleList
	 * 
	 * @return redirect to Rule Home if valid
	 */
	@PostMapping("/ruleName/validate")
	public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
		logger.info("Request = @PostMapping(\"/ruleName/validate\" + @RequestBody = {}", ruleName + ")");

		if (!result.hasErrors()) {
			ruleNameService.saveUpdate(ruleName);
			model.addAttribute("rulename", ruleNameService.listRuleName());
			logger.info("RuleName ajouté avec succès");

			return "redirect:/ruleName/list";

		}
		return "ruleName/add";
	}

	/**
	 * Use for navigate to the update form with the Rule asked
	 * 
	 * @return redirect to Rule update resource
	 */
	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/ruleName/update/" + id + "\")");
		RuleName ruleName = ruleNameService.findRuleNameById(id);
		model.addAttribute("rulename", ruleName);
		return "ruleName/update";
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Rule Home if valid
	 */
	@PostMapping("/ruleName/update/{id}")
	public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName, BindingResult result,
			Model model) {
		logger.info("Request = @PostMapping(\"/ruleName/update/" + id + "\" + @RequestBody = {}", ruleName + ")");

		if (result.hasErrors()) {
			return "/ruleName/update/" + id;
		}

		ruleName.setId(id);
		ruleNameService.saveUpdate(ruleName);
		model.addAttribute("rulename", ruleNameService.listRuleName());
		logger.info("RuleName modifié avec succès");

		return "redirect:/ruleName/list";
	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Rule Home
	 */
	@GetMapping("/ruleName/delete/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
		logger.info("Request = @GetMapping(\"/ruleName/delete/" + id + "\")");

		RuleName ruleName = ruleNameService.findRuleNameById(id);
		ruleNameService.delete(ruleName);
		model.addAttribute("rulename", ruleNameService.listRuleName());
		logger.info("RuleName supprimé avec succès");

		return "redirect:/ruleName/list";
	}
}
