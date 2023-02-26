package jungsuk.generics_enum_annotation.example;


/**
 * 애너테이션 만들기
 * - 애너테이션의 메서드는 추상 메서드
 * - 적용시 값을 지정하지 않으면 사용될 수 있는 기본값 지정 가능 (null 제외)
 * - 요소가 하나이고 이름이 value일 때는 요소의 이름 생략 가능
 * - 요소의 타입이 배열인 경우 괄호를 사용해야 한다.
 *
 *
 * 모든 애너테이션의 조상
 * - Annotation interface : 상속은 불가
 * - hashCode(), toString() 은 구현하지 않고 사용가능
 *
 *
 * Marker Annotation
 * - 요소가 하나도 정의되지 않은 애너테이션
 * ex) @Test, @Deprecated
 *
 * 애너테이션 요소 선언 규칙
 * 1. 요소의 타입은 기본형, String, enum, Annotation, class 만 허용
 * 2. 괄호() 안에 매개변수를 선언할 수 없다.
 * 3. 예외를 선언할 수 없다.
 * 4. 요소를 타입 매개변수로 정의할 수 없다.
 */
public @interface AnnotationEx_2 {
    int id = 100;
//    String major(int i, int j);       // 매개변수 X
//    String minor() throws Exception;  // 예외 X
//    ArrayList<T> list();              // 타입매개변수 X
}
