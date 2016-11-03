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
@Entity
@Table(name = "Profesor")
public class Municipio implements Serializable {

    @Id
    @Column(name="idMunicipio")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idMunicipio;
    private String codProvincia;
    private String codMunicipio;
    private String nombre;

    public Municipio() {
    }

    public Municipio( String codProvincia, String codMunicipio, String nombre) {
        
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
        this.nombre = nombre;
    }

    /**
     * @return the idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * @return the codProvincia
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * @param codProvincia the codProvincia to set
     */
    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    /**
     * @return the codMunicipio
     */
    public String getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * @param codMunicipio the codMunicipio to set
     */
    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
