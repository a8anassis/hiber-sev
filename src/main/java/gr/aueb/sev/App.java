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
//        String jpql = "SELECT t FROM Teacher t";
//        List<Teacher> teachers = em.createQuery(jpql, Teacher.class).getResultList();
//        teachers.forEach(System.out::println);

        // Select all courses
//        String jpql2 = "SELECT c FROM Course c";
//        List<Course> courses = em.createQuery(jpql2, Course.class).getResultList();
//        courses.forEach(System.out::println);

        // Select all courses taught by 'Alice'
//        String jpql3 = "SELECT c FROM Teacher t JOIN t.courses c WHERE t.firstname = 'Alice'";
//        String jpql3 = "SELECT c FROM Course c WHERE c.teacher.firstname = 'Alice'";    // NO SQL Injection
//        String jpql3 = "SELECT c FROM Course c WHERE c.teacher.firstname = :firstname";
//        List<Course> courses = em.createQuery(jpql3, Course.class).setParameter("firstname", "Alice").getResultList();
//        courses.forEach(System.out::println);

        // Select teachers and course titles they teach
//        String jpql4 = "SELECT t, c.title FROM Teacher t JOIN t.courses c";
//        List<Object[]> results = em.createQuery(jpql4, Object[].class).getResultList();
//
//        for (Object[] result : results) {
//            System.out.println(result[0] + " teaches " + result[1]);
//        }

        // Select teacher lastname & count of courses they teach
//        String jpql5 = "SELECT t.lastname, COUNT(c) FROM Teacher t JOIN t.courses c GROUP BY t.lastname";
//        List<Object[]> results = em.createQuery(jpql5, Object[].class).getResultList();
//        for (Object[] result : results) {
//            System.out.println(result[0] + " teaches " + result[1] + " courses");
//        }





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