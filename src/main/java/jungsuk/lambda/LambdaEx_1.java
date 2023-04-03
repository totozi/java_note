package jungsuk.lambda;

public class LambdaEx_1 {
    /**
     * Lambda Expression
     * - 함수형 언어 : Haskell, Scala 등등
     * - 빅데이터가 뜨면서 함수형 언어가 출현, 인기 상승
     * - java는 oop 언어지만 함수형 언어의 기능을 포함한다.
     *
     * 람다식이란?
     * - 함수(메서드)를 간단한 expression으로 표현하는 방법
     * - 익명 함수(anonymous function)
     *
     * 만드는 법
     * 1. 메서드의 이름과 반환타입을 제거하고 '->' 를 블록{} 앞에 추가한다.
     * 2. 반환값이 있는 경우 식이나 값만 적고 return 문 생략 가능
     * 3. 매개변수의 타입이 추론 가능하면 생략가능
     *
     * 함수와 메서드의 차이
     * - 근본적으로 동일. 함수는 일반적 용어, 메서드는 객체지향개념 용어
     * - 함수는 클래스에 독립적, 메서드는 클래스에 종속적 -> 자바에서는 메서드만 있음
     * 작성 시 주의사항
     * 1. 매개변수가 하나인 경우, 괄호() 생략가능(타입이 없을 때만)
     * 2. 하나뿐인 문장이 return문이면 괄호{} 생략 불가
     *
     * - 람다식은 익명 함수가 아니라 익명 객체이다.
     * - 즉, 익명 클래스의 객체이다.
     * - 람다식을 다루기 위한 참조변수가 필요. 참조변수의 타입은?
     */

    public static void main(String[] args) {


        MyFunction2 f = (a,b) -> a > b ? a : b;

        int value = f.max(3,5); // 함수형 인터페이스
        System.out.println("value = " + value);

        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute( () -> System.out.println("run()"));

    }

    static void execute(MyFunction f) { // 매개변수 타입이 Myfunction인 메서드
        f.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드
        MyFunction f  = () -> System.out.println("f3.run()");
        return f;
    }



}

@FunctionalInterface
interface  MyFunction {
    void run();
}

@FunctionalInterface // 추상 메서드가 하나만 가져야 한다.
interface MyFunction2 {
    //public abstract int max(int a, int b);
    int max(int a, int b);
}
