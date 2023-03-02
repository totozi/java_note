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
     * 작성 시 주의사항
     * 1. 매개변수가 하나인 경우, 괄호() 생략가능(타입이 없을 때만)
     * 2. 하나뿐인 문장이 return문이면 괄호{} 생략 불가
     *
     * - 람다식은 익명 함수가 아니라 익명 객체이다.
     * - 즉, 익명 클래스의 객체이다.
     * - 람다식을 다루기 위한 참조변수가 필요. 참조변수의 타입은?
     */

    public static void main(String[] args) {

//        Object obj =  (a, b) -> a > b ? a : b // 람다식. 에러

        Object obj = new Object() {
                int max(int a, int b) {
                    return a > b ?  a : b;
                }
            };

//        int value = obj.max(3, 5); // 에러, Object타입에는 max라는 메서드가 없기 때문에 호출할 수 없다.
        // -> 함수형 인터페이스로 해결..



    }

}
