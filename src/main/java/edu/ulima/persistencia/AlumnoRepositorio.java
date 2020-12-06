package edu.ulima.persistencia;

import edu.ulima.entidad.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepositorio extends JpaRepository<Alumno,String> {

    public Alumno findByIdalumno(String usr);
    /*
    @Query("SELECT p FROM EALUMNO WHERE p.codigo = ?1")
    public Alumno findByCodigo(int cod);
    */
    @Query("SELECT p FROM EALUMNO p WHERE p.nombres = ?1")
    public Alumno findByNombresA(String n);
}
