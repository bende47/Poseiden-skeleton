package com.nnk.springboot.domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "rulename")
public class RuleName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 125)
	@Length(max = 125)
	private String name;

	@Column(length = 125)
	@Length(max = 125)
	private String description;

	@Column(length = 125)
	@Length(max = 125)
	private String json;

	@Column(length = 512)
	@Length(max = 512)
	private String template;

	@Column(length = 125)
	@Length(max = 125)
	private String sqlStr;

	@Column(length = 125)
	@Length(max = 125)
	private String sqlPart;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the json
	 */
	public String getJson() {
		return json;
	}

	/**
	 * @param json the json to set
	 */
	public void setJson(String json) {
		this.json = json;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the sqlStr
	 */
	public String getSqlStr() {
		return sqlStr;
	}

	/**
	 * @param sqlStr the sqlStr to set
	 */
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	/**
	 * @return the sqlPart
	 */
	public String getSqlPart() {
		return sqlPart;
	}

	/**
	 * @param sqlPart the sqlPart to set
	 */
	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}

	public RuleName() {
		super();
	}

	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		super();
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}

	@Override
	public String toString() {
		return "RuleName [name=" + name + ", description=" + description + ", json=" + json + ", template=" + template
				+ ", sqlStr=" + sqlStr + ", sqlPart=" + sqlPart + "]";
	}

}
