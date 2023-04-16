package jungsuk.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex_2 {
    public static void main(String[] args) {

        Stream<Student> studentStream = Stream.of(
                new Student("java1", 3, 300),
                new Student("java2", 1, 200),
                new Student("java3", 2, 100),
                new Student("java4", 2, 150),
                new Student("java5", 1, 200),
                new Student("java6", 3, 290),
                new Student("java7", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan).reversed() // 1. 반별 정렬 + 역순
                .thenComparing(Comparator.naturalOrder()).reversed()) // 2. 기본 정렬 + 역순
                .forEach(System.out::println);

    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    // 총점 내림차순
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore; // 높은사람이 위에
        //return this.totalScore - s.totalScore; // 낮은 사람이 위에
    }
}