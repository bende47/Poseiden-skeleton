package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements CurvePointService{

	@Autowired
	private CurvePointRepository curvePointRepository;
	
	@Override
	public void saveUpdate(CurvePoint curvePoint) {
		curvePointRepository.save(curvePoint);	
	}

	@Override
	public void delete(CurvePoint curvePoint) {
		curvePointRepository.delete(curvePoint);		
	}

	@Override
	public List<CurvePoint> listCurvePoint() {
		return curvePointRepository.findAll();
	}

	@Override
	public CurvePoint findCurvePointById(int id) {
		CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
		return curvePoint;
	}

}
