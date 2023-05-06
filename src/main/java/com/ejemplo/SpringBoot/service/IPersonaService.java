package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void editarPersona(Persona per);
}
