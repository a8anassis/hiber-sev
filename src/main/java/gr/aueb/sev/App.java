package gr.aueb.sev;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;

public class App {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
    private final static EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {

        Teacher bob = new Teacher("Bob", "D.");
        Course sql = new Course("SQL");
        bob.addCourse(sql);

        em.getTransaction().begin();

        em.persist(bob);
        //em.persist(sql);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
