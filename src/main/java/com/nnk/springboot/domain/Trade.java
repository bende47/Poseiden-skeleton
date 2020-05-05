package com.nnk.springboot.domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "trade")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tradeId;

	@Column(length = 30)
	@Length(max = 30)
	private String account;

	@Column(length = 30)
	@Length(max = 30)
	private String type;

	private Double buyQuantity;

	private Double sellQuantity;

	private Double buyPrice;

	private Double sellPrice;

	private LocalDateTime tradeDate;

	@Column(length = 125)
	@Length(max = 125)
	private String security;

	@Column(length = 10)
	@Length(max = 10)
	private String status;

	@Column(length = 125)
	@Length(max = 125)
	private String trader;

	@Column(length = 125)
	@Length(max = 125)
	private String benchmark;

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
	 * @return the tradeId
	 */
	public Integer getTradeId() {
		return tradeId;
	}

	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
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
	 * @return the buyQuantity
	 */
	public Double getBuyQuantity() {
		return buyQuantity;
	}

	/**
	 * @param buyQuantity the buyQuantity to set
	 */
	public void setBuyQuantity(Double buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	/**
	 * @return the sellQuantity
	 */
	public Double getSellQuantity() {
		return sellQuantity;
	}

	/**
	 * @param sellQuantity the sellQuantity to set
	 */
	public void setSellQuantity(Double sellQuantity) {
		this.sellQuantity = sellQuantity;
	}

	/**
	 * @return the buyPrice
	 */
	public Double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the sellPrice
	 */
	public Double getSellPrice() {
		return sellPrice;
	}

	/**
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
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
	 * @return the tradeDate
	 */
	public LocalDateTime getTradeDate() {
		return tradeDate;
	}

	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(LocalDateTime tradeDate) {
		this.tradeDate = tradeDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @param revisionDate the revisionDate to set
	 */
	public void setRevisionDate(LocalDateTime revisionDate) {
		this.revisionDate = revisionDate;
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

	public Trade() {
		super();
	}

	public Trade(String account, String type, Double buyQuantity) {
		super();
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}

	@Override
	public String toString() {
		return "Trade [account=" + account + ", type=" + type + ", buyQuantity=" + buyQuantity + "]";
	}

}
