package java_jungsuk.ch4;

public class Ch4_5 {

    public static void main(String[] args) {
        
        int number = 12334;
        int tmp = number;
        int result = 0;

        while (tmp != 0) {
            
            result = result*10 + tmp % 10;
            tmp /= 10;
        }

        System.out.println(number);
        System.out.println(result);

    }
}
