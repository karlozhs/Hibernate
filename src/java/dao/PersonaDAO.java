package dao;
//Se importan librerias
import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/* @author Carlos Hernandez*/

public class PersonaDAO {
    //Se inicia sesion
    Session session;
    
    public PersonaDAO(){
       //Se obtiene una sesion local
        session=HibernateUtil.getLocalSession();
    }
    //Metodo para obtener el id de una persona
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id);
    }
    //metodo para hacer una busqueda de la lista con la restriccion del nombre
    public List<Persona>  getPersonaByName(String nombre){
        //Se inicia
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre));
        return listaDePersonas;
    }
    //Modifica el valor del nombre de una persona mediante un id
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id);
        try{
                    //Se crea una transaccion
            Transaction transaccion=session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            //Se comunica a base de datos
            session.update(personaAModificar);
           //Peticion 
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //metodo para guardar una nueva persona en base de datos, se inicializan variables
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        //Se crea objeto personaDeTanque para obtener datos
        Persona personaDeTanque=new Persona();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaDeTanque);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{       
        }
        return true;
    }    
}
