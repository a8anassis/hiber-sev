package gr.aueb.sev;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.List;

public class App {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
    private final static EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {



        em.getTransaction().begin();

        // Select all teachers
        String jpql = "SELECT t FROM Teacher t";
        List<Teacher> teachers = em.createQuery(jpql, Teacher.class).getResultList();
        teachers.forEach(System.out::println);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

//        Teacher bob = new Teacher("Bob", "D.");
//        Course sql = new Course("SQL");
//em.persist(sql);
//        bob.addCourse(sql);
//        Teacher alice = em.find(Teacher.class, 1L);
//        alice.setLastname("Wonderland");
//
//        em.merge(alice);


//        em.persist(bob);