
package edu.ulima.formulario;

import edu.ulima.entidad.Seccion;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SeccionForm {
    private String codigo;
    private int courseid;
    private int periodid;
    
    private boolean newSeccion=false;
        private MultipartFile fileData;
        
        
        public SeccionForm()
    {
        this.newSeccion=true;
    }
        public SeccionForm(Seccion s)
        {
            this.codigo=s.getCodigo();
            this.courseid=s.getCourseid();
            this.periodid=s.getPeriodid();
        }
}
