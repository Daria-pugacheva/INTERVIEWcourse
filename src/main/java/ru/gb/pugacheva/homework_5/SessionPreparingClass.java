package ru.gb.pugacheva.homework_5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionPreparingClass {
// В задании сказано сделать этот клас со статическим методов, возвращающим фабрику...Мне кажется, что статика здесь не лучшее решение
    //Я бы , если честно, сделала бы этот класс бином с полем фабрики и создавала бы фабрику в методе init, помеченном Postconstruct
    public static SessionFactory getSessionFactory(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        return factory;
    }
}
