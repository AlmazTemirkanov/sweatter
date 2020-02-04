package com.example.model;

import com.example.domain.SMS;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SMSRepo extends CrudRepository<SMS, Integer> {
    List <SMS> findByDateIgnoreCaseContaining (String date);
    List<SMS> findAllById (Integer id);
}
