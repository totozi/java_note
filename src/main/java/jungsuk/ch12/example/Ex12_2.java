package jungsuk.ch12.example;

import java.util.ArrayList;

public class Ex12_2 {

    // 타입 변수
    // 클래스를 작성할 때, Object 타입 대신 타입변수(E)를 선언해서 사용

    // 객체를 생성시, 타입 변수(E) 대신 실제 타입을 지정(대입)해야한다.

    // 지네릭스 용어
    /*
        Box<T> 지네릭 클래스, 'T의 Box' 또는 'T Box' 라고 읽는다.
        T : 타입 변수 또는 타입 매개변수
        Box : 원시 타입(raw type), 일반클래스

        class Box<T> { } : 지네릭 클래스 선언

        Box<String> b = new Box<String>();
            매개변수화된 타입(parameterized type)
     */



    public static void main(String[] args) {

        // 참조 변수와 생성자의 대입된 타입은 일치해야 한다.
        ArrayList<Tv> tvList = new ArrayList<Tv>();


        tvList.add(new Tv());
        tvList.add(new Tv());
        tvList.add(new Tv());

        Tv tv1 = tvList.get(0); // 형변환 불필요

//        ArrayList<Product> productList = new ArrayList<Tv>(); // 조상이어도 안 됨
        ArrayList<Product> productList = new ArrayList<Product>(); 
        productList.add(new Product());
        productList.add(new Tv()); // Product와 그 자손 객체 가능 -> 다형성

        Tv tv3 = (Tv) productList.get(1); // 타입 불일치로 형변환 해야함

        for (Product p: productList) {
            System.out.println(p.toString());
        }
        //Product
        //Tv


    }

}

class Product {
    @Override
    public String toString() {
        return "Product";
    }
}
class Tv extends Product {
    @Override
    public String toString() {
        return "Tv";
    }
}
