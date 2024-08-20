package com.example.controlclientes2.Dao;

import com.example.controlclientes2.Domain.Persona;
import org.springframework.data.repository.CrudRepository;

/*Creamos una interface llamadaP IPersonaDato y vamos a extender de otra interface llamada
* CrudRepository, la ventaja es que cualquier tipo de clase DAO vamos a poder crearla
* utilizando este mismo repositorio sin tener que agregar los metodos INSERT, DELETE, UPDATE, SELECT
* esta interface hace que se realicen de manera "autormatica".
* Al ser una interfaz generica debemos de indicarle cual es la entidad que va a manipular
* en nuestro caso va a ser el objeto de tipo Persona que genera nuestra clase Persona, seguido del tipo
* de dato que corresponga con nuestra llave primaria de nuestro objeto, en este caso de tipo
* "Long".
* Otra de las ventajas de utilizar esta interface es que no necesitamos crear una clase que
*  implemente la interface "CrudRepository" si no que tambien lo hace de manera automatica. */
public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
