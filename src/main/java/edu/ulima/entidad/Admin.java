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
@Entity(name = "EADMIN")
@Table(name = "TADMIN")
public class Admin implements Serializable {
    
    @Id
    @Column(name="USER", length=200,nullable=false)
    private String user;
    
    @Column(name="CLAVE", length=200, nullable=false)
    private String clave;
    
    @Column(name="NOMBRE", length=200,nullable=false)
    private String nombre;
    
    @Column(name="ROLE", length=200, nullable=false)
    private String role;
}
