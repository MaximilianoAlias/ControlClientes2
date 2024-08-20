package com.example.controlclientes2.Service;

import com.example.controlclientes2.Dao.IPersonaDao;
import com.example.controlclientes2.Domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service /*La etiqueta service le sirve a SpringBoot para reconocer esta clase como una
clase de Servicio - Agregar esta etiqueta es muy importante porque si no no vamos a poder inyectar
esta clase como una implementacion de la interface IPersonaService dentro del controlador, seguidamente
como esta etiqueta tiene una propiedad dentro de ella que se llama "Component" podremos realizar
la inyeccion dentro de la clase controllerInicio con la etiqueta @Autowired*/
public class PersonaServiceImpl implements IPersonaService{

/*
pero debido a que estamos trabajando en la capa de servicio tenemos que agregar un tema más
cuando estamos dentro de la capa dado se maneja el concepto de transacciones.
Esto quiere decir que cualquier operación con la base de datos en dado caso de error se va a ser un
rol back o en caso de que todo sea exitoso entonces se hace un commit.
Pero cuando estamos trabajando con nuestras clases de servicio podríamos estar utilizando varios objetos
de tipo dado desde una misma clase de servicio.
Por lo tanto podríamos estar realizando varias operaciones sobre distintas tablas de la base de datos.
Por lo tanto también estos métodos debemos de marcarlos como transaccionales ya que en dado caso de
error entonces tiene que hacer un rol back y no guardar ninguna información en ninguna de las tablas
afectadas y en dado caso de que todo sea exitoso entonces debe de hacer un comité de toda la transacción
guardando toda la información en todas las tablas afectadas.
Así que dependiendo del tipo de método es el tipo de transacción que vamos a realizar.
Por ejemplo en este método de listar personas únicamente leemos información de la base de datos así
que como solamente vamos a leer información agregamos la anotación de transaccional
importamos esta notación pero debemos tener cuidado ya que no debemos de importar la vas transaction
sino de Spring.
De lo contrario vamos a tener errores para manejar el concepto de transacciones cuando estamos trabajando
con esprín así que importamos esta notación de Spring Framework transaction junto a notación debemos
tener cuidado que se importe de este paquete de Spring y posteriormente debido a que este método únicamente
*/

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
       return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
       return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
