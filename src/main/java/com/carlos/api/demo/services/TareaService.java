package com.carlos.api.demo.services;


import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.api.demo.models.TareaModel;
import com.carlos.api.demo.repositories.TareaRepository;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;
    
    public ArrayList<TareaModel> obtenerTareas(){
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    public TareaModel guardarTareas(TareaModel usuario){
        return tareaRepository.save(usuario);
    }

    public Optional<TareaModel> obtenerPorId(Long id){
        return tareaRepository.findById(id);
    }


    public boolean eliminarTarea(Long id) {
        try{
        	tareaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}