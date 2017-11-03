
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/** @author Carlos Hernandez*/

public class HibernateUtil {
    //crea la sesion
    private static final SessionFactory sessionFactory;
    //se crea sesion local
    private static final ThreadLocal localSession;
    
    static {
        try {
            //Carga configuracion
           Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            //Da contexto a session Factory
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            //Se inicia sesion local. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal();
    }
    //Se inicia sesion 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //Se crea sesion si no existe (Verificacion)
     public static Session getLocalSession() {
        Session session = (Session) localSession.get();
        if (session == null) {
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
     //Se cierra sesion local
     public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("sesion cerrada\n");
    }
}
