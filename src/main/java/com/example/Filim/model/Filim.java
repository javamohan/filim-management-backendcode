package com.example.Filim.model;

import java.util.Date;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



// Mongo database annotation.
/**
 * @author MDEGA, 2021-01-16
 *
 */
@Document(collection= "filim")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Filim {

	@Id
	private String id;
	private String name;
	private String description;
	private Date realeaseDate;
	private int rating;
	private int ticketPrice;
	private String country;
	private List<String> genre;
	private Binary photo;


	
}