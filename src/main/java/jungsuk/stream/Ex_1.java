package jungsuk.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex_1 {
    /**
     * 스트림 만들기
     */
    public static void main(String[] args) {

        // Collection 인터페이스의 stream()으로 컬렉션을 스트림으로 변환

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> integerStream = list.stream(); // list로 stream 생성

        integerStream.forEach(System.out::print); // 최종 연산 후에 stream은 closed
        //integerStream.forEach(System.out::print); // error - stream has already been operated upon or closed
        System.out.println();


        // 객체 배열로부터 스트림 생성
        Stream<String> stringStream1 = Stream.of("a", "b", "c"); // 가변 인자
        Stream<String> stringStream2 = Stream.of(new String[]{"a", "b", "c"});
        Stream<String> stringStream3 = Arrays.stream(new String[]{"a", "b", "c"});
        Stream<String> stringStream4 = Arrays.stream(new String[]{"a", "b", "c"},0, 3);

        stringStream1.forEach(System.out::println);

        // 기본형 배열로부터 스트림 생성
        IntStream intStream1 = IntStream.of(1,2,3,4,5); // 가변인자
        IntStream intStream2 = Arrays.stream(new int[]{1,2,3,4,5}); // 기본형 가능
        Stream<Integer> intStream3 = Arrays.stream(new Integer[]{1,2,3,4,5}); // 기본형 불가능

        System.out.println(intStream1.sum());     // 최종연산
        System.out.println(intStream2.count());   // 최종연산
        //System.out.println(intStream3.average()); // sum이나 averge등은 숫자 스트림에만 있음

        System.out.println();

        // 무한 스트림


        IntStream intStream4 = new Random().ints();
        IntStream intStream5 = new Random().ints(10, 5, 10);
        intStream4.limit(5).forEach(System.out::println);
        System.out.println();
        intStream5.forEach(System.out::println);

        // 특정 범위의 정수
        System.out.println();
        IntStream intStream6 = IntStream.range(1, 5);
        intStream6.forEach(System.out::println);
        System.out.println();

        // 람다식 iterate(). generate()을 통해 스트림 만들기
        // iterate()는 이전 요소를 seed로 해서 다음 요소를 계산한다.
        // generate()는 seed를 사용하지 않는다.

        Stream<Integer> integerStream1 = Stream.iterate(0, n-> n + 2);
        integerStream1.limit(10).forEach(System.out::println);

        // generate안에 Supplier로 구현되어 있어 입력은 없고 출력만 있는 것임
        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(10).forEach(System.out::println);

    }
}
