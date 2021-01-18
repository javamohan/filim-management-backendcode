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
import org.springframework.web.bind.annotation.RequestBody;
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
	public String create(
			@RequestParam(value = "file" , required = false, defaultValue = "defaultFile") MultipartFile multipartFile, 
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "realeaseDate", required = false) Date realeaseDate,
			@RequestParam(value = "rating", required = false) int rating,
			@RequestParam(value = "ticketPrice", required = false) int ticketPrice,
			@RequestParam(value = "country", required = true) String country,
			@RequestParam(value = "genre", required = true) String genre
			) throws IOException {
		logger.debug("Saving Filim... Enter!!");
		Filim filim = new Filim();
		filim.setName(name);
		filim.setDescription(description);
		filim.setRealeaseDate(realeaseDate);
		filim.setRating(rating); // 1 to  5
		filim.setTicketPrice(ticketPrice);
		filim.setCountry(country);
		filim.setGenre(Arrays.asList(genre)); // List
		filim.setPhoto(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
		serv.addFilim(filim);
		return "Filim created.";
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
