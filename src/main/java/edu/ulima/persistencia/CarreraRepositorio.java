
package edu.ulima.persistencia;

import edu.ulima.entidad.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepositorio extends JpaRepository<Carrera,Integer> {
    public Carrera findByCodigo(int car);
}
