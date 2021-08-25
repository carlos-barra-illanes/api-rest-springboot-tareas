package com.carlos.api.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carlos.api.demo.models.TareaModel;
import com.carlos.api.demo.services.TareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/tarea")
@Api(value = "Users microservice", description = "Api de pruebas que mantiene  tareas")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping()         
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    @ApiOperation(value = "Obtiene todas las tareas ", notes = "Retorna todas las tareas de la base de datos" )
    public ArrayList<TareaModel> obtenerTareas(){
        return tareaService.obtenerTareas();
    }
   @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    @PostMapping()
    @ApiOperation(value = "Guarda tareas ", notes = "Retorna estado del resultado " )
    public TareaModel guardarTareas(@RequestBody TareaModel tarea){
        return this.tareaService.guardarTareas(tarea);
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    @GetMapping( path = "/{id}")
    @ApiOperation(value = "Obtiene las tarea por ID ", notes = "Retorna Tarea buscada " )
    public Optional<TareaModel> obtenerTareaPorId(@PathVariable("id") Long id) {
        return this.tareaService.obtenerPorId(id);
    }


    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    @DeleteMapping( path = "/{id}")
    @ApiOperation(value = "Elimina las tarea por ID ", notes = "Retorna estado del resultado" )
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tareaService.eliminarTarea(id);
        if (ok){
            return "Se eliminó la tarea con id " + id;
        }else{
            return "No pudo eliminar el atrea con id" + id;
        }
    }

}