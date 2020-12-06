
package edu.ulima.persistencia;

import edu.ulima.entidad.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepositorio extends JpaRepository<Seccion,String> {
    public Seccion findByCodigo(String cur);
    
}
