package jungsuk.generics_enum_annotation.example;

public class EnumEx_1 {
    public static void main(String[] args) {

        /**
         * - 관련된 상수들을 같이 묶어 놓은 것. Java는 타입에 안전한 열거형을 제공
         * - 열거형 상수 비교에 == 와 comparaTo() 사용가능
         * - but >, < 등의 비교 연산자 사용 불가 -> compareTo() 사용해야함.
         *
         * - 열거형의 조상 - java.lang.Enum(클래스)
         * - values(), valueOf()는 컴파일러가 자동 추가
         */

        Direction d1 = Direction.EAST; // 열거형 타입. 상수이름
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        System.out.println(d1==d2); // false
        System.out.println(d1==d3); // true
        System.out.println(d1.equals(d3)); // true -> 객체이기 때문에 equals를 쓸 수 있다.
        // 즉, 비교 연산자가 사용 불가능!

        System.out.println(d1.compareTo(d2)); // -2
        System.out.println(d1.compareTo(d3)); // 같으므로 0

        switch (d1) {
            case EAST: // Direction.EAST 라고 쓸 수 없다..
                System.out.println(d1);
                break;
            case SOUTH:
                System.out.println(d1);
                break;
            case NORTH:
                System.out.println(d1);
                break;
            case WEST:
                System.out.println(d1);
                break;
            default :
                    System.out.println("default");
        }

        Direction[] dArr = Direction.values();

        for (Direction d: dArr) {
            System.out.println(d.name() +" , " + d.ordinal()); // ordinal은 순서일 뿐 값과 다르다.
        }


    }
}
//                 0     1     2      3
enum Direction { EAST, SOUTH, WEST, NORTH }
