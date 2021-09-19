package com.nikhil.cookbook.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "table_ingredient")
@Getter
@Setter
@ToString
public class IngredientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ingrdientId;
	
	private int receipeId;

	@Column(name = "ingredient")
	private String ingredient;
}
