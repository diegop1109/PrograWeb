
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
@Entity(name = "EPAIS")
@Table(name = "TPAIS")
public class Pais implements Serializable {
    
    @Id
    @Column(name="CODIGO", nullable=false)
    private int codigo;
    
    @Column(name="NOMBRE", length=30, nullable=false)
    private String nombre;
    
}
