
package com.prova02ericdellaicamargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prova02ericdellaicamargo.model.City;
import com.prova02ericdellaicamargo.repository.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public List<City> getCities() {
    List<City> cities = cityRepository.findAll();

    return cities;
  }

  public City getCityById(int id) {
    return cityRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada"));
  }

  public City save(City city) {
    return cityRepository.save(city);
  }

}
