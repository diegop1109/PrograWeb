
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
@Entity(name="ESECCION")
@Table(name="TSECCION")
public class Seccion implements Serializable{
    @Id
    @Column(name="CODIGO", nullable=false)
    private String codigo;
    
    @Column(name="COURSEID", nullable=false)
    private int courseid;
    
    @Column(name="PERIODID", nullable=false)
    private int periodid;
}
