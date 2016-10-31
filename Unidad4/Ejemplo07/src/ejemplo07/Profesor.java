/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo07;

import java.io.Serializable;
import javax.persistence.*;

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
    
    @Enumerated(EnumType.ORDINAL)
    private TipoFuncionario tipoFuncionario;

    public Profesor() {
    }

    public Profesor(int id, Nombre nombre, TipoFuncionario tipoFuncionario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoFuncionario = tipoFuncionario;
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

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    
}
