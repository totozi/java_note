package java_jungsuk.ch4;

public class Ch4_2 {
    public static void main(String[] args) {
        
        int i = 0;
        while(i <= 10)
        {
            int j = 0;
            while(j <= i)
            {
                // System.out.print("*");
                j++;
            }
            // System.out.println();
            i++;
        }


        i = 1;
        while(i <= 6)
        {
            int j = 1;
            while (j <= 6) {
                if(i + j == 6)
                {
                    // System.out.println(i + " + " + j + " = " + (i+j));
                }
                j++;
            }
            i++;
        }


        int value = (int) (Math.random() * 6 + 1);
        // System.out.println(value);
        
        int x = 0;
        while(x <= 10)
        {
            int y = 0;
            while (y <= 10) {
                if((2 * x) + (4 * y) == 10)
                {
                    // System.out.println(x + " , " + y);
                }
                y++;
            }
            x++;
        }


        String str = "12345";
        int sum = 0;

        for(int n = 0; n < str.length(); n++)
        {
            sum += str.charAt(n) - '0';
        }
        // System.out.println(sum);

    }
   
}
