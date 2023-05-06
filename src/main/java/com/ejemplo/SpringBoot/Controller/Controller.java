
package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    
    @Autowired
    private IPersonaService ipersoService;
    
    @PostMapping ("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){
        ipersoService.crearPersona(pers);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody    //Esto indica que lo que retorne la función se agregue al cuerpo de la respuesta a la petición
    public List<Persona> verPersonas(){
        return ipersoService.verPersonas();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        ipersoService.borrarPersona(id);
    }
    
    @PutMapping ("/edit/persona")
    public void editarPersona(@RequestBody Persona pers){
        ipersoService.editarPersona(pers);
    }

    @GetMapping ("/ver/miperfil")
    @ResponseBody    //Esto indica que lo que retorne la función se agregue al cuerpo de la respuesta a la petición
    public Persona verMiPerfil(){
        return ipersoService.buscarPersona((long)1);
    }
     /*
    List<Persona> listaPersonas = new ArrayList();
    
    @GetMapping ("/hola/{nombre}/{apellido}")  //Ante solicitudes GET hechas a localhost:8080/hola se ejecuta el método decirHola()
    public String decirHola(@PathVariable String nombre, @PathVariable String apellido) { // localhost:8080/hola/Vale/Becker
        return "Hola Mundo " + nombre + " " + apellido;
    }
    
    @GetMapping ("/chau")
    public String decirChau(@RequestParam String nombre, @RequestParam String apellido){ // localhost:8080/chau?nombre="Vale"&apellido="Becker"
        return "Chau " + nombre + " " + apellido;
    }
    */
}
