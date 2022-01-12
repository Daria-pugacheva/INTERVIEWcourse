package ru.gb.pugacheva.homework_1.check_code;

class Lorry extends Car implements Movable, Stopable {//синтаксис был кривой - после ключевого слова extends
    // после класса-родителя через запятую шли интерфейсы, т.е. типа множественное наследование, что в Java недопустимо.

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override //эта аннотация необязательная, но полезная для наглядности и проверки, что то, что надо переопределили
    public void move() {
        System.out.println("Car is moving");
    }

    @Override//эта аннотация необязательная, но полезная для наглядности и проверки, что то, что надо переопределили
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override // не был реализован абстрактный метод родителя - добавила
    void open() {
        System.out.println("Car is open");
    }
}
