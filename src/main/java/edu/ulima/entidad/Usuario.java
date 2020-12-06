/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Entity(name = "EUSUARIO")
@Table(name = "TUSUARIO")
public class Usuario implements Serializable {
    
    @Id
    @Column(name="USUARIO", length=50, nullable=false)
    private String usuario;     //este sera el ID con el que entraremos a la pagina
    
    //password del ususario
    @Column(name="CLAVE", length=128, nullable=false)
    private String clave;
}
