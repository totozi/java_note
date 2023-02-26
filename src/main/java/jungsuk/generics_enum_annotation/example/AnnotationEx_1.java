package jungsuk.generics_enum_annotation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *  Annotation : 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공
 *  표준 Annotation : Java에서 제공하는 애너테이션
 *  - 메타 애너테이션 : 애너테이션을 만들 때 사용하는 애너테이션
 *
 */
public class AnnotationEx_1 {
    public static void main(String[] args) {
        /**
         *  @Override
         *  -오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
         *  - 오버라이밍 할 때 메서드 이름을 잘못적는 실수 등을 방지
         *
         *  @Deprecated
         *  - 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
         *  - ex) Date클래스의 getDate();
         *  - 해당 애너테이션이 붙은 코드를 컴파일하면 경고 메시지가 출력된다...
         *
         *  @FunctionalInterface
         *  - 함수형 인터페이스에 붙이면 컴파일러가 올바르게 작성했는지 체크
         *  - 함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있다.
         *
         *  @SuppressWarnings("unchecked") or ({"deprecation", "unchecked"})
         *  - 컴파일러의 경고메시지가 나타나지 않게 억제한다.
         *  - 억제하고자하는 경고의 종류를 문자열로 지정
         *  - 경고를 억제해서 다른 경고만 보기 위해 사용할 수도 있음(정보 선별 목적)
         */

        /**
         *  메타 애너테이션 : 애너테이션을 위한 애너테이션
         *
         *  - @Target : 애너테이션이 적용 가능한 대상을 지정
         *      ex) TYPE : 클래스,인터에시녀 , FIELD 등...
         *
         *  - @Retention : 애너테이션이 유지되는 기간을 지정하는데 사용
         *      : SOURCE, CLASS, RUNTIME
         *      - SOURCE  : 컴파일러에 의해 사용되는 애너테이션의 유지 정책
         *      - CLASS   : 클래스 파일에 존재. 실행시에 사용불가. default
         *      - RUNTIME : 클래스 파일에 존재.
         *
         *  - @Documented
         *       - javadoc으로 작성한 문서에 포함시키려면 붙여야 한다.
         *  - @Inherited
         *      - 애너테이션을 자손 클래스에 상속하고자 할 때 사용한다.
         *  - @Repeatable
         *      - 반복해서 붙일 수 있는 애너테이션을 정의할 때 사용
         *      - 애너테이션을 반복해서 붙일 수 있다.
         *      - 해당 어노태이션을 하나로 묶을 컨테이너 애너테이션도 정의해야 한다.
         *
         */
        new Child().parentMethod();


    }

}

@FunctionalInterface // 에러. 추상 메서드가 2개라서
interface Testable {
    void test();
//    void check();
}

class Parent {
    @Deprecated
    void parentMethod() {}
}

class Child extends Parent {

    @Override
    @SuppressWarnings("deprecation") // warning 사라짐
    void parentMethod() {};
}
