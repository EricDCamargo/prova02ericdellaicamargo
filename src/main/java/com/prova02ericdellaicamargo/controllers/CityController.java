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
import java.util.stream.Collectors;

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
    if (result.hasErrors()) {
      List<String> errors = result.getFieldErrors().stream()
          .map(err -> err.getDefaultMessage())
          .collect(Collectors.toList());
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    try {
      City createdCity = cityService.save(city);
      return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
