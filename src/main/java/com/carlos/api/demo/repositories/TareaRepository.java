package com.carlos.api.demo.repositories;

import java.util.ArrayList;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.api.demo.models.TareaModel;

@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long> {
   // public abstract ArrayList<TareaModel> findByPrioridad(Integer prioridad);

}