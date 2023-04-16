package jungsuk.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaEx_6 {
    /**
     * 메서드 참조
     */
    public static void main(String[] args) {
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);

        Function<String, Integer> f2 = Integer::parseInt; // method reference

        System.out.println(f.apply("123") instanceof Integer);    // true
        System.out.println(f2.apply("12345") instanceof Integer); // true

        System.out.println();

        Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s2 = MyClass::new;

        Function<Integer, MyClass> f3 = (i) -> new MyClass(i);
        Function<Integer, MyClass> f4 = MyClass::new;

        System.out.println(s.get().getClass().getName());
        System.out.println(s2.get().getClass().getName());
        System.out.println(f3.apply(100).iv);
        System.out.println(f4.apply(200).iv);

        Function<Integer, int[]> fArr1 = (i) -> new int[i];
        Function<Integer, int[]> fArr2 = int[]::new;

        System.out.println(fArr1.apply(10).length);
        System.out.println(fArr2.apply(20).length);

    }
}

class MyClass {

    int iv;

    MyClass() {

    }

    MyClass(int iv) {
        this.iv = iv;
    }
}
