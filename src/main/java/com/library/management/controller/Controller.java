package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.LibraryManagement;
import com.library.management.view.LibraryService;

@RestController
public class Controller {
	
	@Autowired
	public LibraryService service;
	

	//Get All Libraries Data
	@GetMapping("/library")
	public List<LibraryManagement> getAllLibrary() {
		return service.getAllLibrary();
	}
	
	//Get Single Library Name
	@GetMapping("/library/{name}")
	public LibraryManagement getLibrary(@PathVariable("name") String name) {
		return service.getLibrary(name);
	}
	
	//Adding library Data
	@PostMapping("/library")
	public String addLibrary(@RequestBody LibraryManagement data) {
		return service.addLibrary(data);
	}
	
	//Updating Library data
	@PutMapping("/library/{name}")
	public String updateLibrary(@RequestBody LibraryManagement data, @PathVariable("name") String name) {
		return service.updateLibrary(data, name);
	}
	
	//Deleting Library data
	@DeleteMapping("/library/{name}")
	public String deleteLibrary(@PathVariable("name") String name) {
		return service.deleteLibrary(name);
	}
}
