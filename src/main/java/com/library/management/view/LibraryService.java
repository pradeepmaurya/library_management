package com.library.management.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.management.model.LibraryManagement;

@Component
public class LibraryService {
	
	public static List<LibraryManagement> list = new ArrayList<>();
	


	static {
		list.add(new LibraryManagement("Gowtami Grandhalam", "Rajahamudry, Andhra Pradesh", 837, "Wi-Fi"));
		list.add(new LibraryManagement("Delhi Public Library", "Delhi", 78, "Wi-Fi & Lunch"));
		list.add(new LibraryManagement("Nehru Memorial Museum", "Delhi", 9182, "Wi-Fi"));
		list.add(new LibraryManagement("Goa State Library", "Goa", 833, "Wi-Fi & Lunch"));
		
	}

	
	
	//fetching Library using getAllMapping
	public List<LibraryManagement> getAllLibrary() {
		return list;
	}
	
	//Fetching for Single library
	public LibraryManagement getLibrary(String name) {
		for(LibraryManagement library:list) {
			if(library.getName().equals(name)) {
				return library;
			}
		}
		return null;
	}
	
	
	//Updating Library by Name
	public String updateLibrary(LibraryManagement data, String name) {
		for(LibraryManagement library:list) {
			System.out.println(library.getName()+" "+name);
			if(library.getName().equals(name)) {
				library.setName(data.getName());
				library.setAddress(data.getAddress());
				library.setNumber(data.getNumber());
				library.setFacilities(data.getFacilities());
				
				return "Succesfully Updated";
			}
		}
		return "Not Found";
	}
	
	//Adding library Data one more
	public String addLibrary(LibraryManagement data) {
		list.add(data);
		return "Succesfully Added"; 
	}
	
	//Delete Library using name
	public String deleteLibrary(String name) {
		for(LibraryManagement library:list) {
			if(library.getName().equals(name)) {
				list.remove(library);
				return "Succesfully Removed";
			}
		}
		return "Failled Due to Not Found";
	}
}
