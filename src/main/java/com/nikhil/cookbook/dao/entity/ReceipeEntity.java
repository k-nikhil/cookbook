package com.nikhil.cookbook.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "table_receipe")
@Getter
@Setter
@ToString
public class ReceipeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "receipe_id")
	private int receipeId;

	@Column(name = "creation_timestamp")
	private String creationTimeStamp;

	@Column(name = "veg")
	private boolean veg;

	@Column(name = "suitable_for")
	private int suitableFor;

	@Column(name = "instructions")
	private String instructions;

	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, mappedBy = "receipeId")
	private List<IngredientEntity> ingredient;

}
