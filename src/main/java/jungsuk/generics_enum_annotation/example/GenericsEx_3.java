package jungsuk.generics_enum_annotation.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GenericsEx_3 {

    // Iterator<E>
    // 클래스를 작성할 때. Object 타입 대신 T와 같은 타입 변수 사용
    public static void main(String[] args) {

        /**
         *
         */
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("java", 1,1));
        list.add(new Student("python", 1,2));
        list.add(new Student("c++", 1,3));

        Iterator<Student> it = list.iterator();

        while(it.hasNext()) {
//            Student s2 = (Student) it.next(); // 지네릭스를 사용하지 않으면 형변환 필요

//            Student s = it.next();
//            System.out.println(s.name);

            System.out.println(it.next().name); // 한 줄로 써도 됨 코드 간결.. 가독성은 안 좋은 듯

        }

        /**
         * HashMap<K, V> // 여러개의 타입 변수가 필요한 경우 콤마로 구분자 선언
         */

        HashMap<String, Student> map = new HashMap<>(); // 1.7부터 일치하니까 생성자에 타입 지정 생략 가능

        map.put("java", new Student("java", 1,1));
        map.put("C", new Student("C", 1,2));
        map.put("python", new Student("python", 1,3));

        System.out.println(map.get("java").name);
        System.out.println(map.get("C").classNo);
        System.out.println(map.get("python").studentNo);

//        System.out.println(map);



    }

}

class Student {
    String name = "";
    int classNo;
    int studentNo;

    Student(String name, int classNo, int studentNo) {
        this.name = name;
        this.classNo = classNo;
        this.studentNo = studentNo;
    }
}
