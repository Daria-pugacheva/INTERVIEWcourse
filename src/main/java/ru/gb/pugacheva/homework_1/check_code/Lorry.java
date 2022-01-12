package ru.gb.pugacheva.homework_1.check_code;

class Lorry extends Car, Movable, Stopable {

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

}
