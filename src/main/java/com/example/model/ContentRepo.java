package com.example.model;

import com.example.domain.Content;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepo extends CrudRepository<Content, Integer> {
    List<Content> findByNumberIgnoreCaseContaining (String number);
    List<Content> findByServiceIgnoreCaseContaining (String service);
    List<Content> findAllById (Integer id);
}
