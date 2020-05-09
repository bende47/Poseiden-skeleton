package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
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
public class CurvePointTests {

	@Autowired
	private CurvePointRepository curvePointRepository;
	
	private CurvePoint curvePoint;
	
	@Before
	public  void setup() {
		curvePoint = new CurvePoint(10, 10d, 30d);
	}

	@Test
	public void saveCurvePointTest() {
		curvePoint = curvePointRepository.save(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);
	}
	
	@Test
	public void updateCurvePointTest() {
		curvePoint.setCurveId(20);
		curvePoint = curvePointRepository.save(curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);
	}
	
	@Test
	public void findCurvePointTest() {
		curvePoint = curvePointRepository.save(curvePoint);
		Integer id = curvePoint.getId();
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertTrue(curvePointList.isPresent());
	}
	
	@Test
	public void listCurvePointTest() {
		curvePoint = curvePointRepository.save(curvePoint);
		List<CurvePoint> listResult = curvePointRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
	}
	
	@Test
	public void deleteCurvePointTest() {
		curvePoint = curvePointRepository.save(curvePoint);
		Integer id = curvePoint.getId();
		curvePointRepository.delete(curvePoint);
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertFalse(curvePointList.isPresent());
	}

}
