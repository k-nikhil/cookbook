package com.nikhil.cookbook.dao;

import java.util.List;

import com.nikhil.cookbook.dao.entity.ReceipeEntity;

public interface ReceipeDao {

	List<ReceipeEntity> getAllReceipe();

	ReceipeEntity getReceipeById(int receipeId);

	ReceipeEntity createReceipe(ReceipeEntity entity);

	int deleteReceipe(int receipeId);

	ReceipeEntity updateReceipe(ReceipeEntity entity);

}
