package com.example.Filim.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Filim.model.Filim;
import com.example.Filim.service.FilimService;


/**
 * @author MDEGA, 2021-01-16
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	FilimService serv;

	@GetMapping("/all")
	public String allAccess() {
		return "Film Management: User can add new movie with basic details like Name\n" + 
				"Description\n" +","+ 
				"Realease Date\n" +","+  
				"Rating\n" + ","+ 
				"Ticket Price\n" + ","+ 
				"Photo\n" + 
				" ";
	}
	
	
	@PostMapping(value = "/upload")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String create(/* @RequestParam String name, @RequestParam String description, */
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		logger.debug("Saving employees.");
		Filim emp = new Filim();
		emp.setName("name");
		emp.setDescription("description");
		emp.setRealeaseDate(new Date());
		emp.setRating(3); // 1 to  5
		emp.setTicketPrice(1000);
		emp.setCountry("UAE");
		emp.setGenre(Arrays.asList()); // List
		emp.setPhoto(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
		serv.addFilim(emp);
		return "Employee records created.";
	}


	/**
	 * Method to fetch all filims from the db.
	 * @return List<Filim>
	 */
	@GetMapping(value= "/filims")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Collection<Filim> getAll() {
		logger.debug("Getting all filim.");
		return serv.getAllFilims();
	}

	
	
}
