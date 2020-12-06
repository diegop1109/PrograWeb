
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
@Entity(name="ECURSO")
@Table(name="TCURSO")
public class Curso implements Serializable{
   
    @Id
    @Column(name="CODIGO", length=20, nullable=false)
    private String codigo;
    
    @Column(name="NOMBRE" , length=255, nullable=false)
    private String nombre;  
    
    @Column(name="CARRERA", length=200, nullable=false)
    private String carrera;
}
