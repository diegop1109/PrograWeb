
package edu.ulima.formulario;
import edu.ulima.entidad.Curso;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CursoForm {
    private String codigo;
    private String nombre;
    private String carrera_id;
    
    private boolean newCurso=false;
    private MultipartFile filedata;
    
    public CursoForm()
    {
        this.newCurso=true;
    }
    public CursoForm(Curso c)
    {
        this.codigo=c.getCodigo();
        this.nombre=c.getNombre();
        this.carrera_id=c.getCarrera();
    }
}
