package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "bidlist")
public class BidList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BidListId;

	@Column(length = 30)
	@Length(max = 30)
	@NotBlank(message = "Account is mandatory")
	@NonNull
	private String account;

	@Column(length = 30)
	@Length(max = 30)
	@NotBlank(message = "Type is mandatory")
	@NonNull
	private String type;

	@PositiveOrZero
	@NonNull
	private Double bidQuantity;

	private Double askQuantity;

	private Double bid;

	private Double ask;

	@Column(length = 125)
	@Length(max = 125)
	private String benchmark;

	private LocalDateTime bidListDate;

	@Column(length = 125)
	@Length(max = 125)
	private String commentary;

	@Column(length = 125)
	@Length(max = 125)
	private String security;

	@Column(length = 125)
	@Length(max = 125)
	private String status;

	@Column(length = 125)
	@Length(max = 125)
	private String trader;

	@Column(length = 125)
	@Length(max = 125)
	private String book;

	@Column(length = 125)
	@Length(max = 125)
	private String creationName;

	private LocalDateTime creationDate;

	@Column(length = 125)
	@Length(max = 125)
	private String revisionName;

	private LocalDateTime revisionDate;

	@Column(length = 125)
	@Length(max = 125)
	private String dealName;

	@Column(length = 125)
	@Length(max = 125)
	private String dealType;

	@Column(length = 125)
	@Length(max = 125)
	private String sourceListId;

	@Column(length = 125)
	@Length(max = 125)
	private String side;

	/**
	 * @return the bidListId
	 */
	public Integer getBidListId() {
		return BidListId;
	}

	/**
	 * @param bidListId the bidListId to set
	 */
	public void setBidListId(Integer bidListId) {
		BidListId = bidListId;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the bidQuantity
	 */
	public Double getBidQuantity() {
		return bidQuantity;
	}

	/**
	 * @param bidQuantity the bidQuantity to set
	 */
	public void setBidQuantity(Double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	/**
	 * @return the askQuantity
	 */
	public Double getAskQuantity() {
		return askQuantity;
	}

	/**
	 * @param askQuantity the askQuantity to set
	 */
	public void setAskQuantity(Double askQuantity) {
		this.askQuantity = askQuantity;
	}

	/**
	 * @return the bid
	 */
	public Double getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(Double bid) {
		this.bid = bid;
	}

	/**
	 * @return the ask
	 */
	public Double getAsk() {
		return ask;
	}

	/**
	 * @param ask the ask to set
	 */
	public void setAsk(Double ask) {
		this.ask = ask;
	}

	/**
	 * @return the benchmark
	 */
	public String getBenchmark() {
		return benchmark;
	}

	/**
	 * @param benchmark the benchmark to set
	 */
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	/**
	 * @return the bidListDate
	 */
	public LocalDateTime getBidListDate() {
		return bidListDate;
	}

	/**
	 * @param bidListDate the bidListDate to set
	 */
	public void setBidListDate(LocalDateTime bidListDate) {
		this.bidListDate = bidListDate;
	}

	/**
	 * @return the commentary
	 */
	public String getCommentary() {
		return commentary;
	}

	/**
	 * @param commentary the commentary to set
	 */
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the trader
	 */
	public String getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(String trader) {
		this.trader = trader;
	}

	/**
	 * @return the book
	 */
	public String getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		this.book = book;
	}

	/**
	 * @return the creationName
	 */
	public String getCreationName() {
		return creationName;
	}

	/**
	 * @param creationName the creationName to set
	 */
	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the revisionName
	 */
	public String getRevisionName() {
		return revisionName;
	}

	/**
	 * @param revisionName the revisionName to set
	 */
	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}

	/**
	 * @return the revisionDate
	 */
	public LocalDateTime getRevisionDate() {
		return revisionDate;
	}

	/**
	 * @param revisionDate the revisionDate to set
	 */
	public void setRevisionDate(LocalDateTime revisionDate) {
		this.revisionDate = revisionDate;
	}

	/**
	 * @return the dealName
	 */
	public String getDealName() {
		return dealName;
	}

	/**
	 * @param dealName the dealName to set
	 */
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	/**
	 * @return the dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @param dealType the dealType to set
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	/**
	 * @return the sourceListId
	 */
	public String getSourceListId() {
		return sourceListId;
	}

	/**
	 * @param sourceListId the sourceListId to set
	 */
	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	/**
	 * @return the side
	 */
	public String getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(String side) {
		this.side = side;
	}
	
	
	/**
	 * 
	 */
	public BidList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param account
	 * @param type
	 * @param bidQuantity
	 */
	public BidList(@NotBlank(message = "Account is mandatory") @NotNull String account,
			@NotBlank(message = "Type is mandatory") @NotNull String type, @NotNull Double bidQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

	@Override
	public String toString() {
		return "BidList [account=" + account + ", type=" + type + ", bidQuantity=" + bidQuantity + "]";
	}

}
