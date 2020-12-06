/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.Formulario;

import edu.ulima.entidad.Alumno;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AlumnoForm {
    private String id;
    private String nombres;
    private String apellidos;
    private String correoUniversidad;
    private String correoPersonal;
    private int genero;
    private String codTeam;
    private String codAny;
    private int carrera;
    
    
    private boolean newAlumno = false;
    private MultipartFile fileData;
    
    public AlumnoForm() {
        this.newAlumno = true;
    }
    
    public AlumnoForm(Alumno a){
        this.id = a.getIdalumno();
        this.nombres = a.getNombres();
        this.apellidos = a.getApellidos();
        this.correoUniversidad = a.getCorreoUniversidad();
        this.correoPersonal = a.getCorreoPersonal();
        this.genero = a.getGenero();
        this.codTeam = a.getCodteam();
        this.codAny = a.getCodany();
        this.carrera = a.getCarrera();
        
    
    }
}
