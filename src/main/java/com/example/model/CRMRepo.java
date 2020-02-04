package com.example.model;

import com.example.domain.CRM;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CRMRepo extends CrudRepository<CRM, Integer> {
    List<CRM> findBySrIgnoreCaseContaining (String date);
    List<CRM> findAllById (Integer id);
}
