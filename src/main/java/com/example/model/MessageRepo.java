package com.example.model;

import com.example.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository <Message, Integer> {
    List<Message> findBySeloIgnoreCaseStartingWith (String selo);
   List<Message> findAllById (Integer id);




}


