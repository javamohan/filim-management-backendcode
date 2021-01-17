package com.example.Filim.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Filim.model.Filim;
import com.example.Filim.repository.FilimDao;



/**
 * @author MDEGA, 2021-01-16
 *
 */
@Service
public class FilimServiceImpl implements FilimService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	FilimDao dao;

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FilimService#addFilim(java.util.List)
	 */
	@Override
	public void addFilim(Filim emp) {
		dao.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.FilimService#getAllFilims()
	 */
	@Override
	public Collection<Filim> getAllFilims() {
		return dao.findAll();
	}

}