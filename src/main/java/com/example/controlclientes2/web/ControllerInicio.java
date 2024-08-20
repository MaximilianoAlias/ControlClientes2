package com.example.controlclientes2.web;

import com.example.controlclientes2.Domain.Persona;
import com.example.controlclientes2.Service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerInicio {

/*Para inyectar cualquier dependencia para que sea manejada por nuestro contenedor debemos de
* agregar la anotacion @Autowired que lo que hace es inyectar la interface de IPersonaDato directamente
* para que pueda ser manejada por nuestor controlador*/

    @Autowired // -> Sirve para inyectar en nuestro controlador en este caso.
    private IPersonaService personaService; // -> Inyectamos nuestra capa Logica y no la directa a la base de datos.

    @GetMapping("/")

    public String inicio(Model model){

        var listaPersonas = personaService.listarPersonas();
        /*nuestro personaService va a usar los metodos de nuestra interface IPersonaService ya que
        * esos metodos estan implementados en la clase PersonaServiceImp
        * */
        log.info("Ejecutando la clase ControllerInicio");
        /*Listado de objetos de tipo personas "ListaPersonas" y variable a compartir -- listaPersonas --*/
      model.addAttribute("listaPersonas", listaPersonas);


        return "index";
    }

    //Agregar el pad de "Agregar"
    @GetMapping("/agregar")
    /*Para agregar una nueva persona le pasamos como argumento el objero persona
    * ya que spring automaticamente va a buscar en su "fabrica" el objeto persona
    * para poder agregarlo, si no lo encuentra entonces lo crea para poder agregarlo.*/
    public String agregar (Persona persona){

        /*en el return ponemos "modificar" porque nos va a redirigir a la vista
        * que usaremos para agregar este nuevo objeto y que tambien esta vista
        * va a realizar los 2 casos de uso osea "agregar" y "modificar",*/
        return "modificar";
    }


    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        /*hacemos un return a la vista de "modificar*/
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        /*hacemos un return a la vista de "inicio"*/
        return "redirect:/";
    }

}
