package com.prova02ericdellaicamargo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "TBL_CITY")
@Data
public class City {
@Id     
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotEmpty(message = "O nome não pode estar vazio")
  private String name;

  @NotEmpty(message = "O estado não pode estar vazio")
  private String province;
}
