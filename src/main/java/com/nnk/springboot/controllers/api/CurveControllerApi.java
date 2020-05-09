package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class CurveControllerApi {


	@Autowired
	private CurvePointService curvePointService;

	/**
	 * Use for validate a new Curve Point
	 * 
	 * @return redirect to Curve Point Home if valid
	 */

	@PostMapping("/curvePoint")
	public String validate(@RequestBody CurvePoint curvePoint) {
		curvePoint.setCreationDate(new Date());
		curvePointService.saveUpdate(curvePoint);
		return "CurvePoint ajouté avec succès";

	}

	/**
	 * Return add Curve Point list
	 * 
	 * @return itself update
	 */

	@GetMapping("/curvePoint")
	public List<CurvePoint> allCurvePoint() {
		return curvePointService.listCurvePoint();
	}

	/**
	 * Use for update a bid and validate it
	 * 
	 * @return redirect to Curve Point Home if valid
	 */

	@PutMapping("/curvePoint/{id}")
	public String updateBid(@PathVariable("id") Integer id, @RequestBody CurvePoint curvePoint) {

		if (curvePointService.findCurvePointById(id) == null) {
			return "CurvePoint introuvable";
		} else {
			curvePoint.setId(id);
			curvePoint.setAsOfDate(new Date());
			curvePointService.saveUpdate(curvePoint);
			return "CurvePoint modifié avec succèst";
		}

	}

	/**
	 * Use for delete a bid
	 * 
	 * @return redirect to Curve Point Home
	 */

	@DeleteMapping("/curvePoint/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {

		CurvePoint curvePoint = curvePointService.findCurvePointById(id);

		if (curvePoint == null) {
			return "CurvePoint introuvable";
		} else {
			curvePointService.delete(curvePoint);
			return "CurvePoint supprimé avec succès";
		}
	}
}
