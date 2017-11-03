package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** @author Carlos Hernandez*/
//Se hace conexion 
@Entity
//Se hace referencia a la tabla
@Table(name="TipoPersona", catalog="generationHibernate")
public class TipoPersona {
    //Primary Key, se autogenera
    @Id @GeneratedValue
    //Nombre de las columnas
    @Column(name="idTipoPersona")
    private int idTipoPersona;
    
     @Column(name="TipoPersonacol")
    private String TipoPersona;
     
     //constructor vacio para conservar memoria para hacer reflexion
     public TipoPersona(){
         
     }
     
     //Seters y getters 
    /**
     * @regresa el id de Tipo de Persona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
}
