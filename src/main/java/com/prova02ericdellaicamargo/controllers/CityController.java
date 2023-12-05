package com.prova02ericdellaicamargo.controllers;

import com.prova02ericdellaicamargo.model.City;
import com.prova02ericdellaicamargo.services.CityService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping
  public ResponseEntity<List<City>> getCities() {
    List<City> cities = cityService.getCities();
    return new ResponseEntity<>(cities, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<City> getCityById(@PathVariable int id) {
    City city = cityService.getCityById(id);
    return new ResponseEntity<>(city, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createCity(@Valid @RequestBody City city, BindingResult result) {
    City createdCity = cityService.save(city);
    return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
  }

}
