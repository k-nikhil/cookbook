package com.nikhil.cookbook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.cookbook.dao.entity.ReceipeEntity;
import com.nikhil.cookbook.dao.repository.ReceipeRepository;

@Repository
public class ReceipeDaoImpl implements ReceipeDao {

	@Autowired
	ReceipeRepository receipeRepository;

	@Override
	public List<ReceipeEntity> getAllReceipe() {
		System.out.println("here3");
		return receipeRepository.findAll();
	}

	public ReceipeEntity getReceipeById(int receipeId) {
		return receipeRepository.findById(receipeId).orElse(new ReceipeEntity());
	}

	@Override
	public ReceipeEntity createReceipe(ReceipeEntity entity) {

		return receipeRepository.save(entity);
	}

	@Override
	public int deleteReceipe(int receipeId) {
		receipeRepository.deleteById(receipeId);
		return 1;
	}

	@Override
	public ReceipeEntity updateReceipe(ReceipeEntity entity) {
		return receipeRepository.save(entity);
	}

}
