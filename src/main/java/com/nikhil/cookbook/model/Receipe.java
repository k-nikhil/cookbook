package com.nikhil.cookbook.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Receipe implements Serializable {

	private static final long serialVersionUID = 1L;

	private int receipeId;

	private String creationTimeStamp;

	private boolean veg;

	private int suitableFor;

	private String instructions;

	private List<Ingredient> ingredient;
}
