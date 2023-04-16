package jungsuk.stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ex_3 {
    public static void main(String[] args) {
        File[] fileArr = { new File("Ex1.java"),
                           new File("Ex1.bak"),
                           new File("Ex2.java"),
                           new File("Ex1"),
                           new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);

        // map으로 Stream<File> 을 Stream<String> 으로 변환

        Stream<String> filenameStream = fileStream.map(File::getName);
        //Stream<String> filenameStream = fileStream.map((f) -> f.getName()); // 위와 같음
        
        filenameStream.forEach(System.out::println);
        System.out.println();

        fileStream = Stream.of(fileArr); // 다시 stream 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것 제외
                .peek(s -> System.out.printf("filename = %s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
                .peek(s -> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase) // 대문자로 변환
                .distinct() // 중복제거
                .forEach(System.out::println);

        System.out.println();


        // flatMap - 여러 개의 문자열 배열을 하나의 배열로 만들 때 사용

        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "DEF", "JKL"}
        );

        Stream<String> stringStream = strArrStream.flatMap(Arrays::stream);

        stringStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 정규식 : 하나 이상의 공백을 의미
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

    }
}
