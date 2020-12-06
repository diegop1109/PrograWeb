
package edu.ulima.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EGENERO")
@Table(name = "TGENERO")
public class Genero implements Serializable {
    
    @Id
    @Column(name="CODIGO", nullable=false)
    private int codigo;
    
    @Column(name="NOMBRE", length=15, nullable=false)
    private String nombre;
    
}
