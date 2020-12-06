
package edu.ulima.persistencia;


import edu.ulima.entidad.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso,String> {
    public Curso findByCodigo(String usr);
}
