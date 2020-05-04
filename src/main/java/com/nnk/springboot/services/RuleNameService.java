package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.RuleName;

public interface RuleNameService {
	/**
	 * 
	 *  @param RuleName
	 */
	public void saveUpdate(RuleName ruleName);
	
	/**
	 * 
	 * @param RuleName
	 */
	public void delete(RuleName ruleName);
	
	/**
	 * 
	 * @return list RuleName
	 */
	public List<RuleName> listRuleName();
	
	/**
	 * 
	 * @param id
	 * @return RuleName
	 */
	public RuleName findRuleNameById(int id);
}
