
package edu.ulima.controller;

import edu.ulima.entidad.Alumno;
import edu.ulima.entidad.Carrera;
import edu.ulima.entidad.Curso;
import edu.ulima.entidad.Profesor;
import edu.ulima.entidad.Seccion;
import edu.ulima.modelo.AlumnoInfo;
import edu.ulima.modelo.CursoInfo;
import edu.ulima.modelo.ProfesorInfo;
import edu.ulima.modelo.SeccionInfo;
import edu.ulima.persistencia.AlumnoRepositorio;
import edu.ulima.persistencia.CarreraRepositorio;
import edu.ulima.persistencia.CursoRepositorio;
import edu.ulima.persistencia.ProfesorRepositorio;
import edu.ulima.persistencia.SeccionRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @Autowired
    private SeccionRepositorio repoSec;
    
    @Autowired
    private CarreraRepositorio carRepo;
    
    @Autowired
    private CursoRepositorio repoCur;
    
    @Autowired
    private AlumnoRepositorio repoAl;
    
    @Autowired 
    private ProfesorRepositorio profeRepo;
    
    @RequestMapping(value="/")
    public String indice() {
        return "index";
    }
    @RequestMapping(value="/student", method = RequestMethod.GET)
    public String home(Model model) {
        return "LogInAlumno";
    }
    @RequestMapping(value="/misDatos", method = RequestMethod.GET)
    public String misDatos(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userDetails", userDetails);
        
        Profesor pr= profeRepo.findByNombresP(userDetails.getUsername());
        
        model.addAttribute("datosA", pr);
        return "VerProfesor";
    }
    @RequestMapping(value="/misSecciones", method = RequestMethod.GET)
    public String misSecciones(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userDetails", userDetails);
        
        Profesor pr= profeRepo.findByNombresP(userDetails.getUsername());
        
        model.addAttribute("datosA", pr);
        return "misSecciones";
    }
    
    /************************LOGIN***********************************/
    @RequestMapping(value = { "/info" }, method = RequestMethod.GET)
    public String loginAccessa(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userDetails", userDetails);
        
        System.out.println("**********************");
        System.out.println("rol: " + userDetails.getAuthorities().toString());
        System.out.println("nombre: "+userDetails.getUsername());
        System.out.println("********************"); 
        
        String a="";
        if(userDetails.getAuthorities().toString().equals("[PROFESOR]")) {
            a ="VerProfesor";
            Profesor pr= profeRepo.findByNombresP(userDetails.getUsername());
        
            model.addAttribute("datosA", pr);
        }
        if(userDetails.getAuthorities().toString().equals("[ALUMNO]")) {
            a ="datosAlumnos";
            Alumno al= repoAl.findByNombresA(userDetails.getUsername());
        
            model.addAttribute("datosA", al);
        }
        if(userDetails.getAuthorities().toString().equals("[ADMIN]")) {
            a ="VerProfesoresAdmin";
        }
        
        

        return a;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping({"/gProfes"})
    public String listarProfes(Model modelK, @RequestParam(value="page", defaultValue="1") int page){
    
        
        final int maxResult = 10;
        final int maxNavigationPage = 10;
        
        final int pageIndex = page-1 < 0 ? 0: page-1;
        
        //Saber cuantas secciones hay
        int totalRecords = profeRepo.findAll().size();
        
        int totalPages = 0;
        if (totalRecords % maxResult == 0){
            totalPages = totalRecords / maxResult;
        }else {
            totalPages = (totalRecords / maxResult) +1;
        }
        
        int currentPage = pageIndex + 1;
        List<Integer> navigationPages = new ArrayList<>();
        int current = currentPage > totalPages? totalPages: currentPage;
        
        int begin = current - maxNavigationPage/2;
        int end = current - maxNavigationPage/2;
        
        navigationPages.add(1);
        if(begin >2){
            navigationPages.add(-1);
        }
                // Llenar un arreglo con los numero de paginas
        for (int i = begin; i < end; i++) {
            if (i > 1 && i < totalPages) {
                System.out.println("En navigationPages.add " + i );
                navigationPages.add(i);
            }
        }

        if (end < totalPages - 2) {
            navigationPages.add(-1);
        }

        navigationPages.add(totalPages);
        
         
        /*
        Ir a la base de datos pero ..a buscar una pagina de datos
        */
        Pageable pagina = PageRequest.of(pageIndex, maxResult);
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Profesor> result0 = profeRepo.findAll(pagina);
        
        // Convertir la lista de Entidad a Modelo
        List<ProfesorInfo> ltmp = new ArrayList<>(); 
        for (Profesor p: result0) {
            ProfesorInfo pi = new ProfesorInfo(p.getCodigo(), p.getNombres(), p.getApellidos(), p.getCorreoUniversidad(),p.getCorreoUniversidad(),
            p.getUrlFoto(),p.getGenero(),p.getPais(),p.getTtid());
            ltmp.add(pi);
        }
        
        // Generar una pagina
        Page<SeccionInfo> result = new PageImpl(ltmp);
        
        // POner todo en el modelo
        modelK.addAttribute("paginationProducts", result);
        modelK.addAttribute("totalPages", totalPages);
        modelK.addAttribute("navigationPages", navigationPages);
      
        return "VerProfesoresAdmin";
    }
    
    @RequestMapping({"/gSecciones"})
    public String listarSecciones(Model modelS, @RequestParam(value="page", defaultValue="1") int page){
    
        
        final int maxResult = 10;
        final int maxNavigationPage = 10;
        
        final int pageIndex = page-1 < 0 ? 0: page-1;
        
        //Saber cuantas secciones hay
        int totalRecords = repoSec.findAll().size();
        
        int totalPages = 0;
        if (totalRecords % maxResult == 0){
            totalPages = totalRecords / maxResult;
        }else {
            totalPages = (totalRecords / maxResult) +1;
        }
        
        int currentPage = pageIndex + 1;
        List<Integer> navigationPages = new ArrayList<>();
        int current = currentPage > totalPages? totalPages: currentPage;
        
        int begin = current - maxNavigationPage/2;
        int end = current - maxNavigationPage/2;
        
        navigationPages.add(1);
        if(begin >2){
            navigationPages.add(-1);
        }
                // Llenar un arreglo con los numero de paginas
        for (int i = begin; i < end; i++) {
            if (i > 1 && i < totalPages) {
                System.out.println("En navigationPages.add " + i );
                navigationPages.add(i);
            }
        }

        if (end < totalPages - 2) {
            navigationPages.add(-1);
        }

        navigationPages.add(totalPages);
        
         
        /*
        Ir a la base de datos pero ..a buscar una pagina de datos
        */
        Pageable pagina = PageRequest.of(pageIndex, maxResult);
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Seccion> result0 = repoSec.findAll(pagina);
        
        // Convertir la lista de Entidad a Modelo
        List<SeccionInfo> ltmp = new ArrayList<>(); 
        for (Seccion p: result0) {
            SeccionInfo pi = new SeccionInfo(Integer.parseInt(p.getCodigo()), p.getCourseid(), p.getPeriodid());
            ltmp.add(pi);
        }
        
        // Generar una pagina
        Page<SeccionInfo> result = new PageImpl(ltmp);
        
        // POner todo en el modelo
        modelS.addAttribute("paginationProducts", result);
        modelS.addAttribute("totalPages", totalPages);
        modelS.addAttribute("navigationPages", navigationPages);
      
        return "mostrarSecciones";
    }
    
    //PAGINACION CURSOS
    @RequestMapping({"/gCursos"})
    public String listarCursos(Model modelC, @RequestParam(value="page", defaultValue="1") int page){
    
        
        final int maxResult = 10;
        final int maxNavigationPage = 10;
        
        final int pageIndex = page-1 < 0 ? 0: page-1;
        
        //Saber cuantas secciones hay
        int totalRecords = repoCur.findAll().size();
        
        int totalPages = 0;
        if (totalRecords % maxResult == 0){
            totalPages = totalRecords / maxResult;
        }else {
            totalPages = (totalRecords / maxResult) +1;
        }
        
        int currentPage = pageIndex + 1;
        List<Integer> navigationPages = new ArrayList<>();
        int current = currentPage > totalPages ? totalPages : currentPage;
        
        int begin = current - maxNavigationPage/2;
        int end = current + maxNavigationPage/2;
        
        navigationPages.add(1);
        if(begin >2){
            navigationPages.add(-1);
        }
                // Llenar un arreglo con los numero de paginas
        for (int i = begin; i < end; i++) {
            if (i > 1 && i < totalPages) {
                System.out.println("En navigationPages.add " + i );
                navigationPages.add(i);
            }
        }

        if (end < totalPages - 2) {
            navigationPages.add(-1);
        }

        navigationPages.add(totalPages);
        
         
        /*
        Ir a la base de datos pero ..a buscar una pagina de datos
        */
        Pageable pagina = PageRequest.of(pageIndex, maxResult);
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Curso> result0 = repoCur.findAll(pagina);
        
        
        
        // Convertir la lista de Entidad a Modelo
        List<CursoInfo> ltmp = new ArrayList<>(); 
        for (Curso p: result0) {
            CursoInfo pi = new CursoInfo(Integer.parseInt(p.getCodigo()), p.getNombre(), p.getCarrera());
            ltmp.add(pi);
        }
        
        // Generar una pagina
        Page<CursoInfo> result = new PageImpl(ltmp);
        
        // POner todo en el modelo
        modelC.addAttribute("paginationProducts", result);
        modelC.addAttribute("totalPages", totalPages);
        modelC.addAttribute("navigationPages", navigationPages);
      
        return "mostrarCursos";
    }
    
    
    @RequestMapping({"/gAlumnos"})
    public String listarAlumnos(Model modelA, @RequestParam(value="page", defaultValue="1") int page){
    
        
        final int maxResult = 10;
        final int maxNavigationPage = 10;
        
        final int pageIndex = page-1 < 0 ? 0: page-1;
        
        //Saber cuantos alumno hay
        int totalRecords = repoAl.findAll().size();
        
        int totalPages = 0;
        if (totalRecords % maxResult == 0){
            totalPages = totalRecords / maxResult;
        }else {
            totalPages = (totalRecords / maxResult) +1;
        }
        
        int currentPage = pageIndex + 1;
        List<Integer> navigationPages = new ArrayList<>();
        int current = currentPage > totalPages? totalPages: currentPage;
        
        int begin = current - maxNavigationPage/2;
        int end = current - maxNavigationPage/2;
        
        navigationPages.add(1);
        if(begin >2){
            navigationPages.add(-1);
        }
                // Llenar un arreglo con los numero de paginas
        for (int i = begin; i < end; i++) {
            if (i > 1 && i < totalPages) {
                System.out.println("En navigationPages.add " + i );
                navigationPages.add(i);
            }
        }

        if (end < totalPages - 2) {
            navigationPages.add(-1);
        }

        navigationPages.add(totalPages);
        
        
         /*
        Ir a la base de datos pero ..a buscar una pagina de datos
        */
        Pageable pagina = PageRequest.of(pageIndex, maxResult);
        // Invocar al repositorio para que retorne la pagina indicada
        Page<Alumno> result0 = repoAl.findAll(pagina);
        
        // Convertir la lista de Entidad a Modelo
        List<AlumnoInfo> ltmp = new ArrayList<>(); 
        for (Alumno p: result0) {
            AlumnoInfo pi = new AlumnoInfo(p.getCodigo(), p.getNombres(), p.getApellidos(), p.getCorreoUniversidad(), p.getCorreoPersonal(), p.getGenero(), p.getCodteam(), p.getCodany(), p.getCarrera());
            ltmp.add(pi);
        }
        
        // Generar una pagina
        Page<AlumnoInfo> result = new PageImpl(ltmp);
        
        // POner todo en el modelo
        modelA.addAttribute("paginationProducts", result);
        modelA.addAttribute("totalPages", totalPages);
        modelA.addAttribute("navigationPages", navigationPages);
        
    
        return "verAlumnos";
    }
    
}
