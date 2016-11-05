/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo12;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author borja
 */
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {

    @Id
    @Column(name="Id")
    @GeneratedValue( generator = "generador_propietario_hibernate_increment" )
    @org.hibernate.annotations.GenericGenerator(
        name = "generador_propietario_hibernate_increment",
        strategy = "increment"
    
    )
    private int id;

    @Column(name = "nombre")
    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;
    
    @NotNull(message="No puede estar vacio")
    @Size(min = 3, max = 50)
    @Column(name = "ape1")
    private String ape1;
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "ape2")
    private String ape2;

    public Profesor() {
    }

    public Profesor( String nombre, String ape1, String ape2) {       
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

}
