package jungsuk.generics_enum_annotation.example;

import java.util.ArrayList;

public class GenericsEx_5 {
    public static void main(String[] args) {
        /**
         * 와일드 카드 <?>
         * - 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능
         * <? extends T> : 와일드 카드의 상한제한. T와 그 자손들만 가능
         * <? super T>   : 와일드 카드의 하한제한. T와 그 조상들만 가능
         * <?>           : 제한 없음. 모든 타입이 가능. <? extends Object> 와 동일
         *
         * - 메서드의 매개변수에 와일드 카드 사용 가능
         *
         */

        ArrayList<? extends Product> list = new ArrayList<Tv>();
        ArrayList<? extends Product> list2 = new ArrayList<Computer>();

        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
//        fruitBox = new FruitBox<Banana>(); // Fruit만 가능
        
        
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<? extends Fruit> fruitBox1 = new FruitBox<Apple>();
        fruitBox1 = new FruitBox<Banana>(); // 와일드 카드 적용시 이렇게 가능

        fruitBox.add(new Banana());
        fruitBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());


        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox)); // Fruit의 자손인 Apple이 가능



    }


}

class Juice {
    String name;

    Juice(String name) { this.name = name + " Juice"; }

    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box) { // Fruit의 자손 대입 가능
//    static Juice makeJuice(FruitBox<Fruit> box) {         // Fruit의 자손 대입 불가능

        String tmp = "";

        for (Fruit f : box.getList())
            tmp += f + " ";

        return new Juice(tmp);
    }
}

