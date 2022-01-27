package ru.gb.pugacheva.homework_5;

import org.hibernate.SessionFactory;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionPreparingClass.getSessionFactory();
        StudentDaoClass studentDaoClass = new StudentDaoClass(sessionFactory);

        //была мысль, что быстрее добавить столько студентов в рамках одной транзакции, но, поскольку стоит условие,
        //что id заполняется автоматически, стало быть оно должно браться из БД, т.е. нужен для добавления каждого
        //экземпляра коммит. Поэтому заполняю в цикле через вызов метода по добавлению у DAO-слоя.
        for (int i = 1; i < 1001; i++) { // для тестирования, если честно, добавляла 5 студентов
            Student student = new Student("Bob № "+i,5);
            studentDaoClass.addStudent(student);
        }

        System.out.println("Студент с ID 2 = "+studentDaoClass.findById(2L));
        System.out.println("Все студенты изначально = "+ studentDaoClass.findAll());
        Student studentToUpdate=new Student(2L, "Frank",3);
        studentDaoClass.updateStudent(studentToUpdate);
        studentDaoClass.deleteStudent(4L);
        System.out.println("Все студенты после изменения и удаления = "+studentDaoClass.findAll());
    }

}
