package com.example.controlclientes2.Service;

import com.example.controlclientes2.Domain.Persona;

import java.util.List;

public interface IPersonaService {

    //Creamos un metodo publico que va a regresar Lista de objetos de tipo Persona
    public List<Persona> listarPersonas();

    //Creamos el metodo Guardar que recibe el objeto de tipo persona
    public void guardar(Persona persona);

    //Creamos el metodo Eliminar que recibe el objeto de tipo persona a Eliminar
    public void eliminar(Persona persona);

    //Creamos el metodo EncontrarPersona que recibe el objeto de tipo persona a Econtrar
    public Persona encontrarPersona(Persona persona);

}
