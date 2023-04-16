package jungsuk.lambda;

import com.itextpdf.layout.renderer.BlockFormattingContextUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx_2 {
//    public static void main(String[] args) {
//        Predicate<String> isEmptyStr = s -> s.length() == 0;
//        String s = "";
//
//        if(isEmptyStr.test(s)) // if(s.length() == 0)
//            System.out.println("This is an empty String.");
//
//        Supplier f1 = () -> (int)(Math.random() * 100) + 1;
//        System.out.println(f1.get());
//
//        Consumer f2 = i -> System.out.print(i + ", ");
//
//        int[] arr = {1,2,3,4,5};
//        for(int i : arr)
//            f2.accept(i);
//        System.out.println();
//
//        Predicate<Integer> f3 = i -> i%2 == 0;
//
//        System.out.println(f3.test(5));
//
//        Function<Integer,Integer> f4 = i -> i/10*10;
//
//        System.out.println(f4.apply(10));

    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2 == 0; // 짝수 검사
        Function<Integer, Integer> f = i -> i/10*10; // 일의 자리를 0으로 만든다

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);

    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for(T i : list) {
            newList.add(f.apply(i));
        }

        return newList;
    }

    static <T> void makeRandomList(Supplier<T> s, List list) {

        for(int i = 0; i < 10; i++) {
            list.add(s.get());
        }

    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }
    /**
     * [83, 8, 28, 37, 26, 84, 7, 88, 39, 96]
     * [8, 28, 26, 84, 88, 96, ]
     * [80, 0, 20, 30, 20, 80, 0, 80, 30, 90]
     */
}
