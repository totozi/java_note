package jungsuk.variable;

public class Ex1 {
    public static void main(String[] args) {

        System.out.printf("digit:%d%n", 10);
        System.out.printf("hexa:%x%n", 20);
        System.out.printf("float:%f%n", 20.0);
        System.out.printf("char:%c%n", 'A');
        System.out.printf("str:%s%n", "abc");

        String url = "www.hyowonnote.com";
        float f1 = .10f;
        float f2 = 1e1f;
        float f3 = 3.14e3f;
        double d= 1.23465789;

        // %f - 일반적, %e - 지수형태 , %g - 간략하게
        System.out.printf("f1=%f, %e, %g%n", f1, f1, f1);
        System.out.printf("f1=%f, %e, %g%n", f2, f2, f2);
        System.out.printf("f1=%f, %e, %g%n", f3, f3, f3);
        System.out.printf("d=%f %n", d);
        System.out.printf("d=%14.10f %n", d); // 14자리중 10자리는 소수점
        System.out.printf("[%s]%n", url);
        System.out.printf("[%20s]%n", url);
        System.out.printf("[%-20s]%n", url);
        System.out.printf("[%.8s]%n", url);

    }


}
