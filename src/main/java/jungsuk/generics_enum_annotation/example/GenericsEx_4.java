package jungsuk.generics_enum_annotation.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GenericsEx_4 {
    public static void main(String[] args) {
        /**
         * 제한된 지네릭 클래스 : extends로 대입할 수 있는 타입을 제한
         * 인터페이스인 경우에도 extends를 사용
         */

        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Banana> bananaBox = new FruitBox<>();
//        FruitBox<Banana> bananaBox = new FruitBox<Apple>(); 타입 불일치 에러

//        FruitBox<Computer> computerFruitBox = new FruitBox<Computer>(); // 에러
        Box<Computer> computerBox = new Box<Computer>(); // 아무거나 다 가능

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Banana());
//        appleBox.add(new Banana()); // Banana는 Apple의 자손이 아니기 때문에 안 됨

        /**
         * 지네릭스의 제약
         * - 타입 변수에 대입은 인스턴스 별로 다르게 가능
         * -> 그렇기 때문에 static 멤버에 타입 변수 사용 불가
         *    -> 스태틱 멤버는 모든 인스턴스에 공통인데 서로 다른 타입을 사용하게 할 수는 없다.
         * - 배열 및 객체 생성할 때 타입 변수 사용불가. 타입 변수로 배열 선언은 가능 -> 즉  new T 사용 불가
         */

        Box<Apple> appleBox1 = new Box<>();



    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }

    public List<T> getList(){
        return list;
    }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {} // 인터페이스 같이 쓸 때는 &

interface Eatable {

}


class Fruit implements Eatable {

    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

class Banana extends Fruit {
    public String toString() {
        return "Banana";
    }
}

class Computer extends Product {
    public String toString() {
        return "Computer";
    }
}