package java_jungsuk.ch4;

public class Ch4_3 {
    public static void main(String[] args) {
        
        // 피보나치 수열
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        // System.out.print(num1 + ", " + num2);

        for(int i = 0; i < 8; i++)
        {
            num3 = num1 + num2;
            // System.out.print(", " + num3);
            num1 = num2;
            num2 = num3;
        }

        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 3; j++)
            {
                int x = j+1+(i-1)/3*3;
                int y = i%3== 0 ? 3 : i%3;

                if(x > 9) break;

                System.out.print(x+"*"+y+"="+x*y+"\t");
            }
            System.out.println();
            if(i%3==0) System.out.println();

            
        }

    } // end of main
    
}
