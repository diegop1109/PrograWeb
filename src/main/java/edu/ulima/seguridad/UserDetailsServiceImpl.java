
package edu.ulima.seguridad;

import edu.ulima.entidad.Admin;
import edu.ulima.entidad.Alumno;
import edu.ulima.entidad.Profesor;
import edu.ulima.entidad.Usuario;
import edu.ulima.persistencia.AdminRepositorio;
import edu.ulima.persistencia.AlumnoRepositorio;
import edu.ulima.persistencia.ProfesorRepositorio;
import edu.ulima.persistencia.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    
    @Autowired
    private AlumnoRepositorio AlumnoRepo; 
    
    @Autowired
    private ProfesorRepositorio ProfRepo; 
    
    @Autowired
    private AdminRepositorio AdmRepo; 
    
    @Autowired
    private UsuarioRepositorio usuRepo; 
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario user = usuRepo.findByUsuario(userName);
       
        Alumno alumno = AlumnoRepo.findByIdalumno(userName);
        Profesor prof = ProfRepo.findByIdprofesor(userName);
        Admin adm = AdmRepo.findByUser(userName);
        
        
        if(user==null) {
            throw new UsernameNotFoundException("usuario " + userName + " no se encuentra en la DB");
        }
        
        String role="";
        String nombre="";
        String pswd="";
        //ERROR: no se encuentra en la base de datos
        
        if(alumno!=null){
            //throw new UsernameNotFoundException("usuario " + userName + " no se encuentra en la DB");
            role = alumno.getRole();
            nombre = alumno.getNombres();
            pswd = alumno.getClave();
            System.out.println("//////////////////////////");
            System.out.println(role + ", " + nombre + ", " + pswd);
            System.out.println("//////////////////////////");
        }
        if (prof != null) {
            role = prof.getRole();
            nombre = prof.getNombres();
            pswd = prof.getClave();
            System.out.println("//////////////////////////");
            System.out.println(role + ", " + nombre + ", " + pswd);
            System.out.println("//////////////////////////");
        }
        if (adm != null) {
            role = adm.getRole();
            nombre = adm.getNombre();
            pswd = adm.getClave();
            System.out.println("//////////////////////////");
            System.out.println(role + ", " + nombre + ", " + pswd);
            System.out.println("//////////////////////////");
        }
            
        
        
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        grantList.add(authority);
        
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        UserDetails userDetails = (UserDetails) new User(
                nombre, //
                pswd, 
                enabled,
                accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList
                );
        
        System.out.println("//////////////////////////");
        System.out.println(role + ", " + nombre + ", " + pswd);
        System.out.println("//////////////////////////");
        
        /*
        String cod = alumno.getRol();
        GrantedAuthority authority = new SimpleGrantedAuthority(cod);
        
        //
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        grantList.add(authority);
        
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        UserDetails userDetails = (UserDetails) new User(
                alumno.getIdalumno(), //
                alumno.getClave(), 
                enabled,
                accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList
                );
*/
        return userDetails;
    }
    
}
