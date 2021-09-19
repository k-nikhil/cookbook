package com.nikhil.cookbook.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.cookbook.dao.entity.ReceipeEntity;

public interface ReceipeRepository extends JpaRepository<ReceipeEntity, Integer> {

}
