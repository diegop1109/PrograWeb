
package edu.ulima.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInfo {
    private int codigo;
    private String nombres;
    private String apellidos;
    private String email;
    private String email_personal;
    private String fotourl;
    private int genero;
    private int paisid;
    private int tipo;    
}
