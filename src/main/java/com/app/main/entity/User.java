package com.app.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data

@Entity(name="USER")
public class User {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="STATUS", columnDefinition="TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean status;
	
	@Column(name="ROLE")
	private String role;
}
