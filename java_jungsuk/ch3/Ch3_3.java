package java_jungsuk.ch3;

public class Ch3_3 {
    public static void main(String[] args) {
        
        int num = 0;
        System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : 0 ));

        num = 456;
        System.out.println(num / 100 * 100);

        num = 333;
        System.out.println(num / 10 * 10 + 1);

        num = 24;
        System.out.println(((num / 10 + 1) * 10) - num);
        
        int fahrenheit = 100;
        float celsius = (fahrenheit - 32) * 5 / 9f;

        System.out.println(fahrenheit);

        celsius = (int)( celsius * 1000);
        celsius = celsius % 10 >= 5 ? celsius + 10 : celsius;
        celsius = (int) (celsius / 10);
        System.out.println(celsius / 100);

    }
}
