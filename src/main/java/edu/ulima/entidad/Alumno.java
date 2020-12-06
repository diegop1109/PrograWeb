
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
@Entity(name = "EALUMNO")
@Table(name = "TALUMNO")
public class Alumno implements Serializable {
    
    
    @Id
    @Column(name="IDALUMNO", length=50, nullable=false)
    private String idalumno;     //este sera el ID con el que entraremos a la pagina
    
    //password del ususario
    @Column(name="CLAVE", length=128)
    private String clave;
    
    //codigo de porfesor o alumno
    @Column(name="CODIGO")
    private int codigo;
    
    //nombres
    @Column(name="NOMBRES", length=50, nullable=false)
    private String nombres;
    
    //apellidos
    @Column(name="APELLIDOS", length=50, nullable=false)
    private String apellidos;
    
    //correo de la universidad (profesor o alumno)
    @Column(name="CORREOUNIVERSIDAD", length=50, nullable=false)
    private String correoUniversidad;
    
    //correo personal (del profesor o alumno)
    @Column(name="CORREOPERSONAL", length=50, nullable=false)
    private String correoPersonal;
    
    //url de la foto del profesor o alumno
    @Column(name="FOTO", length=100)
    private String urlFoto;
    
    //genero representado por un "int" (supongo que "0" sera hombre y "1" mujer)
    @Column(name="GENERO", nullable=false)
    private int genero;
    
    //pais mediante un int (por ahora que peru sea 1)
    @Column(name="PAIS")
    private int pais;
    
    //carrera mediante un int
    @Column(name="CARRERA")
    private int carrera;
    
    @Column(name = "CODTEAM", length=200, nullable=false)
    private String codteam;
    
    @Column(name = "CODANY", length=200, nullable=false)
    private String codany;
    
    @Column(name = "ROLE", length=200)
    private String role;
}
