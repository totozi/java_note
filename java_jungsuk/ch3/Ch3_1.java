package java_jungsuk.ch3;

public class Ch3_1 {

    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        char c = 'A'; // 65

        int result = 0;

        System.out.println(1+ x); // 이진법 11
        System.out.println(1 + x << 33); // 이진법 110 -> 6
        System.out.println(1 << 33); 
        System.out.println(1 << 1);
        // int는 32비트 리터럴이라 33비트 쉬프트하면 1번 쉬프트와 같음
        
        System.out.println(y >= 5 || x < 0 && x > 2); // true
        System.out.println(x += 2); // 4
        System.out.println(!('A' <= c && c <= 'Z')); // false
        System.out.println('C' - c); // 2
        System.out.println('5' - '0'); // 5
        System.out.println(c+1);
        System.out.println(++c); // 출력 전 증가
        System.out.println(c++); // 출력 후 증가
        System.out.println(c);

        
    }
    
}
