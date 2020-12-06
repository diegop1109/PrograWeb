
package edu.ulima.controller;

import edu.ulima.Formulario.AlumnoForm;
import edu.ulima.entidad.Alumno;
import edu.ulima.entidad.Curso;
import edu.ulima.entidad.Profesor;
import edu.ulima.entidad.Seccion;
import edu.ulima.formulario.CursoForm;
import edu.ulima.formulario.ProfesorForm;
import edu.ulima.formulario.SeccionForm;
import edu.ulima.persistencia.AlumnoRepositorio;
import edu.ulima.persistencia.CursoRepositorio;
import edu.ulima.persistencia.ProfesorRepositorio;
import edu.ulima.persistencia.SeccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
    
    @Autowired
    private SeccionRepositorio secRepo;
    
    @Autowired
    private CursoRepositorio cursoRepo;
    
    @Autowired
    private AlumnoRepositorio repo;
    
    @Autowired
    private ProfesorRepositorio profeRepo;
    
    @RequestMapping(value = { "/adminAlumno" }, method = RequestMethod.GET)
    public String addAlumnos(Model model,@RequestParam(value="code", defaultValue="") String code) {
        AlumnoForm af = null;
        
        if ( code != null  && code.length() > 0) {
           Alumno a = repo.findByIdalumno(code);
           if ( a!= null ) {
               af = new AlumnoForm(a);
           }
        } else {
           af = new AlumnoForm();
        }

        model.addAttribute("aForm", af);
        
        return "agregarAlumnos";
    }
    @RequestMapping(value = { "/crearAlumno" }, method = RequestMethod.POST)   
    public String crearAlumno(Model model, @ModelAttribute("aForm") AlumnoForm aForm) {
 
        String code = aForm.getId();
        Alumno a = null;
        boolean isNew = false;
        if ( code != null) {
            a = repo.findByIdalumno(code);
        }
        if ( a == null ) {
            isNew = true;
            a = new Alumno();
        }
        a.setIdalumno(code);
        a.setNombres( aForm.getNombres());
        a.setApellidos( aForm.getApellidos() );
        a.setCarrera(aForm.getCarrera());
        a.setCodany(aForm.getCodAny());
        a.setCodteam(aForm.getCodTeam());
        a.setCorreoPersonal(aForm.getCorreoPersonal());
        a.setCorreoUniversidad(aForm.getCorreoUniversidad());
        a.setGenero(aForm.getGenero());
        //a.setImagen( alumnoForm.getFileData().getBytes() );
        repo.save(a);

        return "redirect:/gAlumnos";
    }
    
    ///////////////////////7
    @RequestMapping(value = { "/adminProfes" }, method = RequestMethod.GET)
    public String admProf(Model model,@RequestParam(value="code", defaultValue="") String code) {
        ProfesorForm pf = null;
        
        if ( code != null  && code.length() > 0) {
           Profesor p = profeRepo.findByIdprofesor(code);
           if ( p!= null ) {
               pf = new ProfesorForm(p);
           }
        } else {
           pf = new ProfesorForm();
        }

        model.addAttribute("pForm", pf);
        
        return "agregarProfesores";
    }
    
    @RequestMapping(value = { "/crearProfesor" }, method = RequestMethod.POST)   
    public String crearProfesor(Model model,@ModelAttribute("pForm") ProfesorForm pForm) {
 
        String codigo = pForm.getId();
        Profesor p = null;
        boolean isNew = false;
        if ( codigo != null) {
            p = profeRepo.findByIdprofesor(codigo);
        }
        if ( p == null ) {
            isNew = true;
            p = new Profesor();
        }
        p.setIdprofesor(codigo);
        p.setNombres( pForm.getNombres() );
        p.setApellidos( pForm.getApellidos() );
        p.setCorreoUniversidad(pForm.getEmail());
        p.setCorreoPersonal(pForm.getEmail_personal());
        p.setUrlFoto(pForm.getFotourl());
        p.setGenero(pForm.getGenero());
        p.setPais(pForm.getPaisid());
        p.setTtid(pForm.getTipo());
        //a.setImagen( alumnoForm.getFileData().getBytes() );
        profeRepo.save(p);
        
        return "redirect:/gProfes";
    }
    /////////////////////////////////////
    @RequestMapping(value = { "/adminCursos" }, method = RequestMethod.GET)
    public String admCursos(Model model,@RequestParam(value="code", defaultValue="") String code) {
        CursoForm cf = null;
        
        if ( code != null  && code.length() > 0) {
            Curso c = cursoRepo.findByCodigo(code);
            if ( c!= null ) {
                cf = new CursoForm(c);
            }
        } else {
            cf = new CursoForm();
        }
        model.addAttribute("cForm", cf);
        
        return "agregarCursos";
    }
    @RequestMapping(value = { "/crearCurso" }, method = RequestMethod.POST)   
    public String crearCurso(Model model, @ModelAttribute("cForm") CursoForm cForm) {
 
        String codigo = cForm.getCodigo();
        Curso c = null;
        boolean isNew = false;
        if ( codigo != null) {
            c = cursoRepo.findByCodigo(codigo);
        }
        if ( c == null ) {
            isNew = true;
            c = new Curso();
        }
        c.setCodigo(codigo);
        c.setNombre( cForm.getNombre() );
        c.setCarrera(cForm.getCarrera_id());
        cursoRepo.save(c);
        
        return "redirect:/gCursos";
    }
    //////////////////////////////
    @RequestMapping(value = { "/adminSeccion" }, method = RequestMethod.GET)
    public String curso(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
        SeccionForm sf = null;

        if (code != null && code.length() > 0) {
            Seccion s = secRepo.findByCodigo(code);
            if (s != null) {
                sf = new SeccionForm(s);
            }
        } else {
            sf = new SeccionForm();
        }
        model.addAttribute("sForm", sf);

        return "agregarSecciones";
    }
    @RequestMapping(value = { "/crearSeccion" }, method = RequestMethod.POST)   
    public String grabarSeccion(Model model,@ModelAttribute("sForm") SeccionForm sForm) {
 
        String codigo = sForm.getCodigo();
        Seccion s = null;
        boolean isNew = false;
        if ( codigo != null) {
            s = secRepo.findByCodigo(codigo);
        }
        if ( s == null ) {
            isNew = true;
            s = new Seccion();
        }
        s.setCodigo(codigo);
        s.setCourseid(sForm.getCourseid());
        s.setPeriodid(sForm.getPeriodid());
        secRepo.save(s);
        
        return "redirect:/gSecciones";
    }
}