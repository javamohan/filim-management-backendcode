package com.example.Filim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Filim.model.Filim;





/**
 * Interface for manging storing data into mongoDB.
 * @return List<Filim>
 */

/**
 * @author MDEGA, 2021-01-16
 *
 */
@Repository
public interface FilimDao extends MongoRepository<Filim, Integer> {

}