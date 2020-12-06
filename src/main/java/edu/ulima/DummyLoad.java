
package edu.ulima;

import edu.ulima.entidad.Admin;
import edu.ulima.entidad.Alumno;
import edu.ulima.entidad.Carrera;
import edu.ulima.entidad.Curso;
import edu.ulima.entidad.Genero;
import edu.ulima.entidad.Pais;
import edu.ulima.entidad.Profesor;
import edu.ulima.entidad.Seccion;
import edu.ulima.entidad.Usuario;
import edu.ulima.persistencia.AdminRepositorio;
import edu.ulima.persistencia.AlumnoRepositorio;
import edu.ulima.persistencia.CarreraRepositorio;
import edu.ulima.persistencia.CursoRepositorio;
import edu.ulima.persistencia.GeneroRepositorio;
import edu.ulima.persistencia.PaisRepositorio;
import edu.ulima.persistencia.ProfesorRepositorio;
import edu.ulima.persistencia.SeccionRepositorio;
import edu.ulima.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DummyLoad implements CommandLineRunner {
    @Autowired
    private AlumnoRepositorio Arepo;
    @Autowired
    private ProfesorRepositorio Prepo;
    @Autowired
    private CursoRepositorio Crepo;
    @Autowired
    private SeccionRepositorio Srepo;
    @Autowired
    private PaisRepositorio PArepo;
    @Autowired
    private CarreraRepositorio CArepo;
    @Autowired
    private GeneroRepositorio GErepo;
    @Autowired
    private PasswordEncoder pwd;
    @Autowired
    private AdminRepositorio Adrepo;
    @Autowired
    private UsuarioRepositorio Urepo;
    
    ///HAY UN PROBLEMA CON LAS CONTRASEÑAS. ERROR DE VALUE TOO LONG
    @Override
    public void run(String... args) throws Exception {
        //INSERT.save, DELETE-remove, UPDATE-merge, SELECT-find/select
        
        Urepo.save(new Usuario("admin", pwd.encode("1234")));
        Urepo.save(new Usuario("001", pwd.encode("1234")));
        Urepo.save(new Usuario("1003", pwd.encode("1234")));
        
        //admin(user, calve, nombre)
        Adrepo.save(new Admin("admin", pwd.encode("1234"), "EL PEPE", "ADMIN"));
        
        
        //id, contraseña, codigo, nombres, apellidos, correo de la u, correo personal, foto, genero, pais, carrera
        
        Arepo.save(new Alumno("001", pwd.encode("1234"), 001, "Leonardo", "Sipion Guillen", "2020web@ulima.edu.pe", "Xx_leo_xX@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 1, "","","ALUMNO"));
        Arepo.save(new Alumno("002", pwd.encode("1234"), 002, "Diego Ricardo", "Mendoza Mercado", "2012web@ulima.edu.pe", "aaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 2, 2, "", "","ALUMNO"));
        Arepo.save(new Alumno("003", pwd.encode("1234"), 003, "Ian", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("004", pwd.encode("1234"), 003, "jorge", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("005", pwd.encode("1234"), 003, "fran", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("006", pwd.encode("1234"), 003, "rick", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("007", pwd.encode("1234"), 003, "diego", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("008", pwd.encode("1234"), 003, "aaaa", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("009", pwd.encode("1234"), 003, "ayuda", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("010", pwd.encode("1234"), 003, "pepe", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("011", pwd.encode("1234"), 003, "jose", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("012", pwd.encode("1234"), 003, "tanta", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("013", pwd.encode("1234"), 003, "luis", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("014", pwd.encode("1234"), 003, "miriam", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("015", pwd.encode("1234"), 003, "sebastian", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("016", pwd.encode("1234"), 003, "lucho", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("017", pwd.encode("1234"), 003, "dede", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("018", pwd.encode("1234"), 003, "juan", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        Arepo.save(new Alumno("019", pwd.encode("1234"), 003, "aaasdad", "Bustinza", "2010web@ulima.edu.pe", "111111@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 1, 3, "", "","ALUMNO"));
        
        
        
        //profesor(id, contraseña, codigo, nombres, apellidos, correo de la u, correo personal, foto, genero, pais, tipo de profesor)
        Prepo.save(new Profesor("1003", pwd.encode("1003"), 1003, "Ian", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1004", pwd.encode("1003"), 1004, "dasd", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1005", pwd.encode("1003"), 1005, "Iadfdn", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1006", pwd.encode("1003"), 1006, "aaaaaaaaa", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1007", pwd.encode("1003"), 1007, "quino", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1008", pwd.encode("1003"), 1008, "alva", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1009", pwd.encode("1003"), 1009, "jorge", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1010", pwd.encode("1003"), 1010, "luis", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1011", pwd.encode("1003"), 1011, "jena", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1012", pwd.encode("1003"), 1012, "raul", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1014", pwd.encode("1003"), 1014, "jean", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1013", pwd.encode("1003"), 1013, "piero", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1015", pwd.encode("1003"), 1015, "eda", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1016", pwd.encode("1003"), 1016, "uwu", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1017", pwd.encode("1003"), 1017, "O_O", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        Prepo.save(new Profesor("1018", pwd.encode("1003"), 1018, "OwO", "Bustinza", "2010web@profe.edu.pe", "aaaaaaaaaaaaa@gmail.com", "https://www.pixiv.net/en/artworks/85765309", 0, 3, 1, "PROFESOR"));
        
        //CURSO(id, nombre, carrera)
        Crepo.save(new Curso("11111", "Programacion web", "1"));
        Crepo.save(new Curso("11122", "IngDATOS", "1"));
        Crepo.save(new Curso("3242", "LP", "1"));
        Crepo.save(new Curso("222", "poo", "1"));
        Crepo.save(new Curso("333", "cloud", "1"));
        Crepo.save(new Curso("5555", "calculo1", "2"));
        Crepo.save(new Curso("44", "gestope", "2"));
        Crepo.save(new Curso("131313", "mezclar cemento", "3"));
        Crepo.save(new Curso("2323", "tu waifu", "2"));
        Crepo.save(new Curso("442", "maqueta", "4"));
        Crepo.save(new Curso("1113322", "aaaaaa", "1"));
        Crepo.save(new Curso("444", "aaaaaaaaaaaaaaaaaaaaa", "1"));
        Crepo.save(new Curso("654", "rwrwerrwrwqr", "1"));
        
        
        //SECCION(id, id curso, id periodo)
        Srepo.save(new Seccion("701", 11111, 7));
        
        //PAIS(id, nombre)
        PArepo.save(new Pais(1, "Peru"));
        PArepo.save(new Pais(2, "Argentina"));
        PArepo.save(new Pais(3, "Brazil"));
        
        //CARRERA(id, nombre)
        CArepo.save(new Carrera(1, "Ingenieria de sistemas"));
        CArepo.save(new Carrera(2, "Ingenieria Industrial"));
        CArepo.save(new Carrera(3, "Comunicaciones"));
        
        //GENERO
        GErepo.save(new Genero(0, "MASCULINO"));
        GErepo.save(new Genero(1, "FEMENINO"));
        
        //ADMIN
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
