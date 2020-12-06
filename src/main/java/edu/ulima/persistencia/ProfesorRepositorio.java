
package edu.ulima.persistencia;

import edu.ulima.entidad.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfesorRepositorio extends JpaRepository<Profesor,String> {
    public Profesor findByIdprofesor(String cor);
    
    @Query("SELECT p FROM EPROFESOR p WHERE p.codigo = ?1")
    public Profesor findByCodigo(int cod);
    
    @Query("SELECT p FROM EPROFESOR p WHERE p.nombres = ?1")
    public Profesor findByNombresP(String n);
    
}
