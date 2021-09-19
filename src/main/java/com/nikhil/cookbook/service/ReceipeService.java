package com.nikhil.cookbook.service;

import java.util.List;

import com.nikhil.cookbook.model.Receipe;

public interface ReceipeService {

	public List<Receipe> getAllReceipe();

	public Receipe getReceipeById(int receipeId);

	public Receipe createReceipe(Receipe receipe);

	public int deleteReceipe(int receipeId);

	public Receipe updateReceipe(Receipe receipe);

}
