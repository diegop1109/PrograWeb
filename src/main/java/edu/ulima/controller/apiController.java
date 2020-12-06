/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.controller;

import edu.ulima.entidad.Alumno;
import edu.ulima.entidad.Curso;
import edu.ulima.entidad.Profesor;
import edu.ulima.entidad.Seccion;
import edu.ulima.persistencia.AlumnoRepositorio;
import edu.ulima.persistencia.CursoRepositorio;
import edu.ulima.persistencia.ProfesorRepositorio;
import edu.ulima.persistencia.SeccionRepositorio;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class apiController {
    @Autowired
    private ProfesorRepositorio profeRepo;
    
    @Autowired
    private CursoRepositorio cursoRepo;
    
    @Autowired
    private SeccionRepositorio secRepo;
    
    @Autowired
    private AlumnoRepositorio alumRepo;
    
    @GetMapping("/buscar/profesor/{codigo}")
    public Profesor ListaProfesor(
    @PathVariable(value="codigo") int codigo)
    {
        Profesor lp=profeRepo.findByCodigo(codigo);
        return lp;
    }
    @GetMapping("/buscar/curso/{codigo}")
    public Curso ListaCurso(
    @PathVariable(value="codigo") String codigo)
    {
        Curso lp=cursoRepo.findByCodigo(codigo);
        return lp;
    }
    @GetMapping("/buscar/seccion/{codigo}")
    public Seccion ListaSeccion(
    @PathVariable(value="codigo") String codigo)
    {
        Seccion lp=secRepo.findByCodigo(codigo);
        return lp;
    }
    @GetMapping("/buscar/alumno/{codigo}")
    public Alumno ListaAlumno(
    @PathVariable(value="codigo") String codigo)
    {
     Alumno lp=alumRepo.findByIdalumno(codigo);

        return lp;
    }
    @DeleteMapping("/eliminarProfesor/{codigo}")
    public Map<String,Boolean> eliminarProfesor( @PathVariable(value="codigo") int codigo) 
            throws ResponseStatusException {
        Profesor p = profeRepo.findByCodigo(codigo);
        
        if ( p == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Codigo no existe " + codigo);
        }  
        
        profeRepo.delete(p);
        Map<String,Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
        
    }
    @DeleteMapping("/eliminarCurso/{codigo}")
    public Map<String,Boolean> eliminarCurso( @PathVariable(value="codigo") String codigo) 
            throws ResponseStatusException {
        Curso p = cursoRepo.findByCodigo(codigo);
        
        if ( p == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Codigo no existe " + codigo);
        }  
        
        cursoRepo.delete(p);
        Map<String,Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
        
    }
    @DeleteMapping("/eliminarAlumno/{codigo}")
    public Map<String,Boolean> eliminarAlumno( @PathVariable(value="codigo") String codigo) 
            throws ResponseStatusException {
        Alumno p = alumRepo.findByIdalumno(codigo);
        
        if ( p == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Codigo no existe " + codigo);
        }  
        
        alumRepo.delete(p);
        Map<String,Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
        
    }
    @DeleteMapping("/eliminarSeccion/{codigo}")
    public Map<String,Boolean> seccionEliminar( @PathVariable(value="codigo") String codigo) 
            throws ResponseStatusException {
        Seccion p = secRepo.findByCodigo(codigo);
        
        if ( p == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Codigo no existe " + codigo);
        }  
        
        secRepo.delete(p);
        Map<String,Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return response;
        
    }
}
