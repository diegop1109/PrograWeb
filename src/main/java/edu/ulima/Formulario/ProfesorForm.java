
package edu.ulima.formulario;

import edu.ulima.entidad.Profesor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProfesorForm {
    private String id;
    private String nombres;
    private String apellidos;
    private String email;
    private String email_personal;
    private String fotourl;
    private int genero;
    private int paisid;
    private int tipo;    
    
    private boolean newProfesor=false;
    private MultipartFile fileData;
        
    public ProfesorForm()
    {
        this.newProfesor=true;
    }
    public ProfesorForm(Profesor p)
    {
        this.id=p.getIdprofesor();
        this.nombres=p.getNombres();
        this.apellidos=p.getApellidos();
        this.email=p.getCorreoUniversidad();
        this.email_personal=p.getCorreoPersonal();
        this.fotourl=p.getUrlFoto();
        this.genero=p.getGenero();
        this.paisid=p.getPais();
        this.tipo=p.getTtid();
    }

    
}
