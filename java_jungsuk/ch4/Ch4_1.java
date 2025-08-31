package java_jungsuk.ch4;

public class Ch4_1 {
    public static void main(String[] args) {


        int sum = 0;
        for(int i = 0; i <= 20; i++)
        {
            if( !(i % 2 == 0 || i % 3 == 0))
            {
                sum += i;
            }

        }
        System.out.println(sum);

        int i = 0;
        sum = 0;
        while (i <= 10) {
            
            for(int j = 1; j <= i; j++)
            {
                sum += j;
            }
            
            i++;
        }
        System.out.println(sum);

        sum = 0;
        i = 1;
        while(true)
        {
            sum += i;

            if (sum >= 100) {
                break;
            }

            if(i > 0) i++;
            else if(i < 0) i--;

            i = -1 * i;
            
        }
        System.out.println(i);
        
        
        
    }
    
}
