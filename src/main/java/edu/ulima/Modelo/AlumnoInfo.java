
package edu.ulima.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoInfo {
    private int codigo;
    private String nombres;
    private String apellidos;
    private String correoUniversidad;
    private String correoPersonal;
    private int genero;
    private String codTeam;
    private String codAny;
    private int carrera;
}
