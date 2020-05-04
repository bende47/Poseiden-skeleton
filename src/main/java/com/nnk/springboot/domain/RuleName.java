package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "rulename")
public class RuleName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="Name is mandatory")
	@NotNull
	private String name;
	@NotBlank(message="Description is mandatory")
	@NotNull
	private String description;
	@NotBlank(message="Json is mandatory")
	@NotNull
	private String json;
	@NotBlank(message="Template is mandatory")
	@NotNull
	private String template;
	@NotBlank(message="Sql Str is mandatory")
	@NotNull
	private String sqlStr;
	@NotBlank(message="Sql Part is mandatory")
	@NotNull
	private String sqlPart;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getSqlStr() {
		return sqlStr;
	}
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}
	public String getSqlPart() {
		return sqlPart;
	}
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
