package jungsuk.lambda;

import java.util.function.*;

public class LambdaEx_4 {
    public static void main(String[] args) {

        Function<String ,Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer ,String> g = (i) -> Integer.toBinaryString(i);

        // f의 출력과 g의 입력이 같으므로 andThen 사용해서 합치기 가능
        Function<String, String> h = f.andThen(g); // 함수 합치기 f하고 g해라

        // g -> f로 만들기
        Function<Integer, Integer> h2 = f.compose(g); //

        System.out.println(h.apply("FF"));
        System.out.println(h2.apply(2));

        Function<String, String> f2 = x -> x; // 항등함수(identity function)
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i > 100;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100;

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));


        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println();
        System.out.println(str1 == str2); // false, 주소비교이므로 false

        Predicate<String> p2 = Predicate.isEqual(str1); // 값 비교(equals 메서드 사용)
        boolean result = p2.test(str2);
        boolean result2 = Predicate.isEqual(str1).test(str2);
        System.out.println(result); // true, 값 비교(equals 메서드 사용)
        System.out.println(result2);


    }
}
