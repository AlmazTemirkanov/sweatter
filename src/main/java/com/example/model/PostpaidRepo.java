package com.example.model;

import com.example.domain.Postpaid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostpaidRepo extends CrudRepository <Postpaid, Integer>  {

    List <Postpaid> findByCountryIgnoreCaseStartingWith (String country);
    List<Postpaid> findAllById (Integer id);
}
