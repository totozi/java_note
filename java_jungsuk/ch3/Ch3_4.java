package java_jungsuk.ch3;

public class Ch3_4 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a + b);
        /*
         * 자바에서 byte, short, char 같은 작은 정수 타입끼리 
         * 산술 연산(+, -, *, /)을 하면 자동으로 int로 승격
         */
        char ch = 'A';
        ch = (char) (ch + 2);
        float f = 3 / 2;
        long l = 3000 * 3000 * 3000;
        float f2 = 0.1f;
        double d = 0.1;
        boolean result = d==f2;
        System.out.println("c="+c);
        System.out.println("ch="+ch);
        System.out.println("f="+f);
        System.out.println("l="+l);
        System.out.println("result="+result);

        ch = '!';

        if (ch >= '0' && ch <= '9') {
            System.out.println(true);
        } 
        else if( ch >= 'a' && ch <= 'z') 
        {
            System.out.println(true);
        }
        else if( ch >= 'A' && ch <= 'Z') 
        {
             System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }

        ch = 'B';

        if( ch >= 'A' && ch <= 'Z') 
        {
            ch = (char) (ch + 32);
            System.out.println(ch);
        }
    }
    
}
