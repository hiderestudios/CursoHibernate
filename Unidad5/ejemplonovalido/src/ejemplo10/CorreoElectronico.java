/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo10;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author borja
 */
@Entity
@Table(name="CorreoElectronico")
public class CorreoElectronico implements Serializable {
    
    @Id
    @Column(name="IdCorreo")
    private int idCorreo;
    @Column(name="DireccionCorreo")
    private String direccionCorreo;
    
    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private Profesor profesor;

    
    public CorreoElectronico() {
    }

    public CorreoElectronico(int idCorreo, String direccionCorreo, Profesor profesor) {
        this.idCorreo = idCorreo;
        this.direccionCorreo = direccionCorreo;
        this.profesor = profesor;
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
