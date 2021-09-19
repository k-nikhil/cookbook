package com.nikhil.cookbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.cookbook.dao.ReceipeDaoImpl;
import com.nikhil.cookbook.dao.entity.IngredientEntity;
import com.nikhil.cookbook.dao.entity.ReceipeEntity;
import com.nikhil.cookbook.model.Receipe;

@Service
public class ReceipeServiceImpl implements ReceipeService {

	@Autowired
	ReceipeDaoImpl receipeDao;

//	@Autowired
//	private Mapper mapper;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;
//	private ReceipeMapper mapper = Mappers.getMapper(ReceipeMapper.class);

	@Override
	public List<Receipe> getAllReceipe() {
		List<ReceipeEntity> receipeEntityList = receipeDao.getAllReceipe();
		return receipeEntityList.stream().map(entity -> dozerBeanMapper.map(entity, Receipe.class))
				.collect(Collectors.toList());
	}

	@Override
	public Receipe getReceipeById(int receipeId) {
		ReceipeEntity receipeEntity = receipeDao.getReceipeById(receipeId);
		return new DozerBeanMapper().map(receipeEntity, Receipe.class);
	}

	@Override
	public Receipe createReceipe(Receipe receipe) {
		ReceipeEntity receipeEntity = receipeDao.createReceipe(new DozerBeanMapper().map(receipe, ReceipeEntity.class));
		return new DozerBeanMapper().map(receipeEntity, Receipe.class);
	}

	@Override
	public int deleteReceipe(int receipeId) {
		receipeDao.deleteReceipe(receipeId);
		return 1;
	}

	@Override
	public Receipe updateReceipe(Receipe receipe) {
		return new DozerBeanMapper()
				.map(receipeDao.updateReceipe(new DozerBeanMapper().map(receipe, ReceipeEntity.class)), Receipe.class);
	}

}
