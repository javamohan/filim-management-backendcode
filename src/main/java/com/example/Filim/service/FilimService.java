package com.example.Filim.service;

import java.util.Collection;

import com.example.Filim.model.Filim;




/**
 * @author MDEGA, 2021-01-16
 *
 */
public interface FilimService {

	/**
	 * Method to create new filim in the db using mongo-db repository.
	 * @param emp
	 */
	public void addFilim(Filim emp);

	/**
	 * Method to fetch all filim from the db using mongo-db repository.
	 * @return
	 */
	public Collection<Filim> getAllFilims();

}