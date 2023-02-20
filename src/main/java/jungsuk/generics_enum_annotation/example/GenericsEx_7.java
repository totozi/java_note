package jungsuk.generics_enum_annotation.example;

public class GenericsEx_7 {

    public static void main(String[] args) {
        /**
         *  - 지네릭 타입과 원시 타입 간의 형변환은 바람직하지 않다.(경고 발생)
         *  - 와일드 카드가 사용된 지네릭 타입으로는 형변환 가능
         */
        Box<Object> objBox = null;
        Box box = (Box) objBox;
        // OK. 지네릭 타입 Box<Object> -> 원시타입 Box : 경고 발생
        objBox = (Box<Object>) box;
        // OK. 원시 타입 Box -> 지네릭 타입 Box<Object> : 경고 발생

        // 위의 예는 아래와 같다
        Box b = new Box<String>();
        b.add(new Integer(100)); // 가능 -> 원시 타입과 섞어 쓰지 않는 게 좋다

//        Box<String> b1 = new Box<Object>(); // 에러. 형변환 불가


        Box<? extends Object> wBox = new Box<String>(); // OK
        Box<? extends Object> wBox2 = (Box<? extends Object>) new Box<String>(); // 위 문장과 동일

        FruitBox<? extends Fruit> fbox = new FruitBox<Apple>(); // 자동 형변환
        // FruitBox<Apple>() -> FruitBox<? extends Fruit> 자동 형변환

        FruitBox<? extends Fruit> abox = new FruitBox<Apple>();
        FruitBox<Apple> applebox = (FruitBox<Apple>)abox; // 형변환 가능하긴 함


        /**
         * 지네릭 타입의 제거
         * - 컴파일러는 지네릭 타입을 제거하고, 필요한 곳에 형변환을 넣는다.
         * 1. 지네릭 타입의 경계(bound)를 제거
         * 2. 지네릭 타입 제거 후에 타입이 불일치하면, 형변환 추가
         * 3. 와일드 카드가 포함된 경우, 적절한 타입으로 형변환 추가
         */

    }
}


