
package edu.ulima.persistencia;

import edu.ulima.entidad.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepositorio extends JpaRepository<Genero,Integer> {
    public Genero findByCodigo(int gen);
}
