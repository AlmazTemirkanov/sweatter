package com.example.model;

import com.example.domain.Prepaid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrepaidRepo extends CrudRepository <Prepaid, Integer> {
    List<Prepaid> findByCountryIgnoreCaseStartingWith (String country);
    List<Prepaid> findAllById (Integer id);
}
