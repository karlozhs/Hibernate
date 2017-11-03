package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**@author Carlos Hernandez */
//Se crea conexion
@Entity
//Se hace referencia a la tabla que vamos a utilizar
@Table(name="Persona",catalog="generationHibernate")
public class Persona {
    //Primary Key se autogenera
    @Id @GeneratedValue
    //nombre de la columna
    @Column(name="idPersona")
    private int idPersona;
    //Campo no puede estar vacio
    @Column(name="Nombre",nullable=true)
    private String Nombre;
    //columna paterno
    @Column(name="Paterno")
    private String Paterno;
    //columna materno
     @Column(name="Materno")
    private String Materno;
     //columna telefono
     @Column(name="Telefono")
    private String Telefono;
    
     //relacion de muchos a uno
     @ManyToOne
     
     //donde haras el match, llave foranea
     @JoinColumn(name="idTipoPersona")
     
    private TipoPersona tipoPersona;
//Seters y Geters abtractos:
    /**
     * @regresa el id de Persona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}