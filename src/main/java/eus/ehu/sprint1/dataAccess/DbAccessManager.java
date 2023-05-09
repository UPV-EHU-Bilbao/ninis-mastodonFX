package eus.ehu.sprint1.dataAccess;

import eus.ehu.sprint1.configuration.Config;
import eus.ehu.sprint1.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * Implements the Data Access utility to the objectDb database
 */
public class DbAccessManager {

    protected EntityManager db;
    protected EntityManagerFactory emf;

    public DbAccessManager() {

        this.open();

    }

    public void open() {
        open(false);
    }


    public void open(boolean initializeMode) {

        Config config = Config.getInstance();

        System.out.println("Opening DataAccess instance => isDatabaseLocal: " +
                config.isDataAccessLocal() + " getDatabBaseOpenMode: " + config.getDataBaseOpenMode());

        String fileName = config.getDatabaseName();
        if (initializeMode) {
            fileName = fileName + ";drop";
            System.out.println("Deleting the DataBase");
        }

        if (config.isDataAccessLocal()) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy(registry);
            }

            db = emf.createEntityManager();
            System.out.println("DataBase opened");
        }
    }


    public void storeUser(User user) {
        db.getTransaction().begin();
        db.persist(user);
        db.getTransaction().commit();
    }
    public String getTOKEN(String username) {
        db.getTransaction().begin();
        User user = db.find(User.class, username);
        db.getTransaction().commit();
        return user.getTOKEN();
    }

    public void reset() {
        db.getTransaction().begin();
//    db.createQuery("DELETE FROM Table").executeUpdate();
        db.getTransaction().commit();
    }

    public void initializeDB() {

        this.reset();



        try {

            db.getTransaction().begin();


            generateTestingData();

            db.getTransaction().commit();
            System.out.println("The database has been initialized");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void generateTestingData() {
        // create domain entities and persist them
    }



    public void close() {
        db.close();
        System.out.println("DataBase is closed");
    }

    public User login(String username) {
        db.getTransaction().begin();
        User user = db.find(User.class, username);
        db.getTransaction().commit();
        return user;
    }

    public String getUserString(String username) {
        db.getTransaction().begin();
        User user = db.find(User.class, username);
        db.getTransaction().commit();
        if (user!=null){
            return user.getUsername();
        }
        else {
            return "null";
        }

    }
    public ArrayList<String> getAllUsernames(){

        TypedQuery<String> query = db.createQuery("SELECT username FROM User",
                String.class);
        ArrayList<String> usernames = (ArrayList<String>) query.getResultList();
        return usernames;
    }

}