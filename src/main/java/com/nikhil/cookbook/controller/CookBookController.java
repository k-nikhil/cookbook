package com.nikhil.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.cookbook.model.Receipe;
import com.nikhil.cookbook.service.ReceipeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cookbook")
public class CookBookController {

	@Autowired
	ReceipeServiceImpl receipeService;

	@Operation(summary = "Get All Receipes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = " ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Receipe.class)) }),
			@ApiResponse(responseCode = "400", description = " ", content = @Content),
			@ApiResponse(responseCode = "404", description = " ", content = @Content) })
	@GetMapping("/receipe")
	public ResponseEntity<Receipe> getAllReceipe() {
		return new ResponseEntity(receipeService.getAllReceipe(), HttpStatus.OK);
	}

	@GetMapping("/receipe/{receipeId}")
	public ResponseEntity<Receipe> getReceipe(@PathVariable int receipeId) {
		return new ResponseEntity(receipeService.getReceipeById(receipeId), HttpStatus.OK);
	}

	@PostMapping("/receipe")
	public ResponseEntity<Receipe> createReceipe(@Parameter @RequestBody Receipe receipe) {
		return new ResponseEntity(receipeService.createReceipe(receipe), HttpStatus.OK);
	}

	@DeleteMapping("/receipe/{receipeId}")
	public ResponseEntity<Receipe> deleteReceipe(@RequestParam int receipeId) {
		return new ResponseEntity(receipeService.deleteReceipe(receipeId), HttpStatus.OK);
	}

	@PatchMapping("/receipe/{receipeId}")
	public ResponseEntity<Receipe> updateReceipe(@RequestBody Receipe receipe) {
		return new ResponseEntity(receipeService.updateReceipe(receipe), HttpStatus.OK);
	}

}
