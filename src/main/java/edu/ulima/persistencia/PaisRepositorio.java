
package edu.ulima.persistencia;

import edu.ulima.entidad.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais,Integer> {
    public Pais findByCodigo(int pa);
}
