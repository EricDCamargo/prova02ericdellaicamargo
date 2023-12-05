package com.prova02ericdellaicamargo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova02ericdellaicamargo.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    
}
