package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.CurvePoint;

public interface CurvePointService {
	/**
	 * 
	 *  @param CurvePoint
	 */
	public void saveUpdate(CurvePoint curvePoint);
	
	/**
	 * 
	 * @param CurvePoint
	 */
	public void delete(CurvePoint curvePoint);
	
	/**
	 * 
	 * @return list curvePoint
	 */
	public List<CurvePoint> listCurvePoint();
	
	/**
	 * 
	 * @param id
	 * @return CurvePoint
	 */
	public CurvePoint findCurvePointById(int id);
}
