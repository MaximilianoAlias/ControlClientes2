package com.example.controlclientes2.Domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/*cuando usamos la etiqueta de @Data de "lombok" esta nos crea automaticamente
 * pero de manera no visible, los getters, setters, el constructor, los metodos
 * equals, hascode, canequals y toString*/
@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //Indica cual es el campo de la llave primaria en nuestra base de Datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue indica como generar el valor de esta llave primaria
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
