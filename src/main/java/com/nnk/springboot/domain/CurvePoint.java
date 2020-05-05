package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "must not be null")
	private Integer curveId;
	private Date asOfDate;
	@NotNull(message = "must not be null")
	private Double term;
	@NotNull(message = "must not be null")
	private Double value;
	private Date creationDate;
			
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the curveId
	 */
	public Integer getCurveId() {
		return curveId;
	}
	/**
	 * @param curveId the curveId to set
	 */
	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}
	/**
	 * @return the asOfDate
	 */
	public Date getAsOfDate() {
		return asOfDate;
	}
	/**
	 * @param asOfDate the asOfDate to set
	 */
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	/**
	 * @return the term
	 */
	public Double getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(Double term) {
		this.term = term;
	}
	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public CurvePoint() {
		super();
	}
	
	public CurvePoint(Integer curveId, Double term, Double value) {
		super();
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "CurvePoint [curveId=" + curveId + ", term=" + term + ", value=" + value + "]";
	}
	
	
	
	
	
}
