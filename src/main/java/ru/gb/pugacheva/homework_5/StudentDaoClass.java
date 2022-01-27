package ru.gb.pugacheva.homework_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDaoClass {

    SessionFactory sessionFactory;

    public StudentDaoClass(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStudent(Student student){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println(student);
        }

    }

    public void deleteStudent(Long id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public void updateStudent(Student student){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student updatedStudent =session.get(Student.class, student.getId());
            updatedStudent.setName(student.getName());
            updatedStudent.setMark(student.getMark());
            session.getTransaction().commit();
        }
    }

    public Student findById(Long id){
        Student student;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            student=session.get(Student.class, id);
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> findAll(){
        List<Student> students;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            students=session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
        }
        return students;
    }
}
