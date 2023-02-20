package jungsuk.generics_enum_annotation.example;

import java.util.Comparator;
import java.util.List;

public class GenericsEx_6 {
    /**
     * 지네릭 메서드 : 지네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효)
     * - 메서드를 호출할 때마다 타입을 대입해야(대부분 생략가능)
     *
     *
     *
     * 와일드 카드 vs 지네릭 메서드
     * - 와일드 카드 : 하나의 참조변수로 서로 다른 타입이 대입된 여러 지네릭 객체를 다루기 위한 것
     * - 지네릭 메서드 : 메서드를 호출할 때마다 다른 지네릭 타입을 대입할 수 있게 한 것
     */
    public static void main(String[] args) {
        Ex_6.<String>genericsMethod("string");
        Ex_6.genericsMethod("string"); // <String> 생략 가능

    }
}

class Ex_6<T> {

    static <T extends String> void genericsMethod(T param) {
        System.out.println("genericsMethod....");
    }

    void dummyMethod() {
        // 메서드를 호출할 때 타입을 쓸 때는 클래스 이름 생략 불가
//        <String>genericsMethod("class");  // 에러
        this.<String>genericsMethod("class"); // OK
        Ex_6.<String>genericsMethod("class"); // OK
    }

    static <T> void  sort(List<T> list, Comparator<? super T> c) {
        // 이 영역에서는 메서드 선언부에 선언된 T가 우선한다.
        // 클래스에 선언된 T != 메서드에 선언된 T

    }
}
