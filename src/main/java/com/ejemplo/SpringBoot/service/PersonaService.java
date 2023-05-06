package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired  //INYECCIÓN DE DEPENDENCIA: crea una dependencia con otra clase, se ocupa de crear la instancia
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @GetMapping("personas/traer/perfil")
    public Persona buscarPersona(Long id){
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarPersona(Persona per) {
        persoRepo.save(per);
    }
    
}
