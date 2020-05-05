package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements RuleNameService {
	
	@Autowired
	private RuleNameRepository ruleNameRepository;
	
	@Override
	public void saveUpdate(RuleName ruleName) {
		ruleNameRepository.save(ruleName);
	}

	@Override
	public void delete(RuleName ruleName) {
		ruleNameRepository.delete(ruleName);
	}

	@Override
	public List<RuleName> listRuleName() {
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName findRuleNameById(int id) {
    	RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid RuleName Id:" + id));
		return ruleName;
	}

}
