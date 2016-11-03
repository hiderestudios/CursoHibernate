/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo10;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author borja
 */
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {
    
    @Id
    @Column(name="Id")
    private int id;
    @Embedded
    private Nombre nombre;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="IdProfesor")
    @IndexColumn(name="idx")
    private List<CorreoElectronico> correosElectronicos;

     @OneToOne(cascade=CascadeType.ALL)
     @PrimaryKeyJoinColumn
     private Direccion direccion;
     
    public Profesor() {
    }

    public Profesor(int id, Nombre nombre) {
        this.id = id;
        this.nombre = nombre;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public List<CorreoElectronico> getCorreosElectronicos() {
        return correosElectronicos;
    }

    public void setCorreosElectronicos(List<CorreoElectronico> correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
