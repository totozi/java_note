package jungsuk.ch12.example;

import java.util.ArrayList;
import java.util.Objects;

public class Ex12_1 {

    // Generics란?
    // 컴파일시 타입을 체크해주는 기능
    // 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄여줌 -> 코드 간결

    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add(10);
        list.add(20);
        list.add("30");

        Integer i = (Integer) list.get(2); // 컴파일 OK
        // Object를 반환하고 Integer로 형변환하기 때문에 컴파일러가 볼 때는 문제가 없다.
        // 하지만 실제로는 String이라 실행 시 에러가 남.. (java.lang.ClassCastException)
        // 컴파일러의 한계 -> 이를 위해 Generics 사용

        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(10); // new Integer(10) 으로 autoboxing -> TODO Authboxing 찾아보기
        list2.add(20);
//        list2.add("30");  // 타입체크가 강화됨, 컴파일 에러 발생 -> 실행 시 에러가 컴파일 에러로 미리 알 수 있음
        
        Integer i2 = list2.get(1); // 형변환 필요 없음

        /*
            ArrayList list = new ArrayList();
            ArrayList<Object> list = new ArrayList<Object>(); <- 지네릭스 등장 이후로는 이렇게 써야함
            ArrayList가 일반클래스에서 ArrayList<E> 라는 지네릭 클래스로 바뀌었으므로
        */

        /*
            Exception 중 RuntimeException 중
            ClassCastException,
            NullPointerException(참조변수가 null일 때 메서드 호출 등)
            ... 등 의 exception들을 어떻게 하면 컴파일에 체크할 수 있을까?

            ClassCastException을 컴파일 단계로 가져와주는게 Generics의 기능 중 하나

         */

        String str = null;
        String str2 = ""; // 이게 더 낫다 NullPointerException 발생 확률이 줄기 때문에

        // 마찬가지로
        Object[] objArr = null;
        Object[] objArr2 = new Object[0]; // 이렇게 초기화하는 게 나음




    }

}
