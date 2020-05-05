package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleTests {

	@Autowired
	private RuleNameRepository ruleNameRepository;

	private RuleName rule;
	
	@Before
	public void setup() {
		rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
	}

	@Test
	public void saveRuleTest() {
		rule = ruleNameRepository.save(rule);
		Assert.assertNotNull(rule.getId());
		Assert.assertTrue(rule.getName().equals("Rule Name"));
	}
	@Test
	public void updateRuleTest() {
		rule.setName("Rule Name Update");
		rule = ruleNameRepository.save(rule);
		Assert.assertTrue(rule.getName().equals("Rule Name Update"));
	}
	
	@Test
	public void findRuleTest() {
		rule = ruleNameRepository.save(rule);
		Integer id = rule.getId();
		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
		Assert.assertTrue(ruleList.isPresent());
	}
	
	@Test
	public void listRuleTest() {
		List<RuleName> listResult = ruleNameRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
	}
	@Test
	public void deleteRuleTest() {
		rule = ruleNameRepository.save(rule);
		Integer id = rule.getId();
		ruleNameRepository.delete(rule);
		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
		Assert.assertFalse(ruleList.isPresent());
	}
}
