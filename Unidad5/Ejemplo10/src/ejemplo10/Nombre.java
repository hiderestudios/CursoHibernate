package ejemplo10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author borja
 */
@Embeddable
class Nombre implements Serializable {
    @Column(name="nombre")
    private String nombre;
    @Column(name="ape1")
    private String ape1;
    @Column(name="ape2")
    private String ape2;

    public Nombre(){
        
    }

    public Nombre(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
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
    
    
    
        public String getNombreCompleto() {
        StringBuilder sb=new StringBuilder();
        if ((ape1!=null) && (ape1.trim().length()>0)) {
            sb.append(ape1);
        }        
        if ((ape2!=null) && (ape2.trim().length()>0)) {
            if (sb.length()>0) {
                sb.append(" ");
            }
            sb.append(ape2);
        }         
        if ((nombre!=null) && (nombre.trim().length()>0)) {
            if (sb.length()>0) {
                sb.append(",");
            }
            sb.append(nombre);
        }
       
        
        return sb.toString();
    }
    
    public String getIniciales() {
        StringBuilder sb=new StringBuilder();
        if ((nombre!=null) && (nombre.trim().length()>0)) {
            sb.append(nombre.substring(0,1));
        }
        if ((ape1!=null) && (ape1.trim().length()>0)) {
            sb.append(ape1.substring(0,1));
        }        
        if ((ape2!=null) && (ape2.trim().length()>0)) {
            sb.append(ape2.substring(0,1));
        }        
        
        return sb.toString().toUpperCase();
    } 
    

}
