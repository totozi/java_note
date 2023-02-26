package jungsuk.generics_enum_annotation.example;


/**
 *  - 불연속적인 값을 원하는 경우 직접 지정해주어야 한다.
 */
enum Direction2 {
    // 괄호를 사용해서 원하는 값을 지정하려면 인스턴스 변수와 생성자를 새로 추가해줘야 한다.
    EAST(1,">"), SOUTH(2, "V"), WEST(3,"<"), NOTRH(4,"^") ;


    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value; // 정수를 저장할 필드(인스턴스 변수) 추가
    private final String symbol;

    // 열거형의 생성자는 묵시적으로 private이므로 외부에서 객체 생성 불가
    Direction2(int value, String symbol) {
        this.value = value; // 생성자 추가
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction2 of(int dir) {
        if(dir < 1 || dir > 4) { // 0~3 범위 벗어나면 예외
            throw new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    // 방향 회전
    public Direction2 rotate(int num) {
        num = num % 4;
        if(num < 0) num +=4; // 음수의 경우

        return DIR_ARR[(value -1 + num) % 4];
    }

    public String toString() {
        return name() + " : " + getSymbol();
    }

}

public class EnumEx_2 {
    public static void main(String[] args) {
        for(Direction2 d : Direction2.values()) {
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));

    }
}
