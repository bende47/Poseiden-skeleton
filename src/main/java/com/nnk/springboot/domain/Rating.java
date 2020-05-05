package com.nnk.springboot.domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 125)
	@Length(max = 125)
	private String moodysRating;

	@Column(length = 125)
	@Length(max = 125)
	private String sandPRating;

	@Column(length = 125)
	@Length(max = 125)
	private String fitchRating;

	private Integer orderNumber;

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
	 * @return the moodysRating
	 */
	public String getMoodysRating() {
		return moodysRating;
	}

	/**
	 * @param moodysRating the moodysRating to set
	 */
	public void setMoodysRating(String moodysRating) {
		this.moodysRating = moodysRating;
	}

	/**
	 * @return the sandPRating
	 */
	public String getSandPRating() {
		return sandPRating;
	}

	/**
	 * @param sandPRating the sandPRating to set
	 */
	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}

	/**
	 * @return the fitchRating
	 */
	public String getFitchRating() {
		return fitchRating;
	}

	/**
	 * @param fitchRating the fitchRating to set
	 */
	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	/**
	 * @return the orderNumber
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Rating() {
		super();
	}

	public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
		super();
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Rating [moodysRating=" + moodysRating + ", sandPRating=" + sandPRating + ", fitchRating=" + fitchRating
				+ ", orderNumber=" + orderNumber + "]";
	}

}
