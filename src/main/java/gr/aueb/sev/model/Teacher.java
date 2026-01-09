package gr.aueb.sev.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", length = 255, nullable = false, unique = false)     // default values
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST) // best practice
    private Set<Course> courses = new HashSet<>();

//    public Teacher() { }
//
    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    protected Set<Course> getCourses() {
//        return courses;
//    }
//
    public Set<Course> getAllCourses() {
        return Collections.unmodifiableSet(courses);
    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setTeacher(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.setTeacher(null);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
