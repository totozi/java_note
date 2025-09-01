package java_jungsuk.ch4;

import java.util.Scanner;

public class Ch4_4 {
    public static void main(String[] args) {

        String value = "12o34";
        // char ch = ' ';
        boolean isNumber = true;

        for(char ch : value.toCharArray())
        {
            if(!(ch >= '0' && ch <= '9'))
            {
                isNumber = false;
                // System.out.println(ch);
                break;
            }
        }
        // System.out.println(isNumber);
        
        int answer = (int) (Math.random() * 100) + 1;
        int input = 0;
        int count = 0;

        java.util.Scanner scan = new java.util.Scanner(System.in);

        do {

            count++;
            System.out.print("1과 100사이 값 입력하세요.");
            input = scan.nextInt();

            if(answer > input) System.out.println("더 큰 수를 입력하세요.");
            else if(answer < input) System.out.println("더 작은 수를 입력하세요.");
            else {
                System.out.println("정답");
                System.out.println(count);
                break;
            }

        } while (true);

        scan.close();


    }
    
}
