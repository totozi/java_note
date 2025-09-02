package java_jungsuk.ch5;

public class Ch5_1 {
    public static void main(String[] args) {

        // 5-2
        // int[][] arr = {
        // { 5, 5, 5, 5, 5},
        // { 10, 10, 10},
        // { 20, 20, 20, 20},
        // { 30, 30}
        // };

        // System.out.println(arr[3].length);
        
        // 5-3
        // int[] arr = {10, 20, 30, 40, 50};
        // int sum = 0;

        // for(int n : arr)
        // {
        //     sum += n;
        // }
        // System.out.println(sum);

        // 5-4
        // int[][] arr = {
        // { 5, 5, 5, 5, 5},
        // {10,10,10,10,10},
        // {20,20,20,20,20},
        // {30,30,30,30,30}
        // };
        
        // int total = 0;
        // float average = 0;
        // int cnt = 0;

        // for(int[] arr1 : arr)
        // {
        //     for(int ele : arr1)
        //     {
        //         total += ele;
        //         cnt++;
        //     }
        // }
        // System.out.println(total);
        
        // average = (float) (total) / cnt;
        // System.out.println(average);

        // 5-5
        // int[] ballArr = {1,2,3,4,5,6,7,8,9};
        // int[] ball3 = new int[3];

        // for(int i = 0; i < ballArr.length; i++)
        // {
        //     int j = (int) (Math.random() * ballArr.length);
            
        //     int tmp;
        //     tmp = ballArr[i];
        //     ballArr[i] = ballArr[j];
        //     ballArr[j] = tmp;
        // }

        // for(int n : ballArr)
        // {
        //     System.out.print(n + " ");
        // }

        // 5-6
        // int[] coinUnit = {500, 100, 50, 10};

        // int money = 3250;
        // System.out.println(money);

        // for(int coin : coinUnit)
        // {   
        //     int cnt = 0;
        //     while (money / coin > 0) {
        //         cnt++;
        //         money -= coin;
        //     }
        //     System.out.println(coin + " : " + cnt);
        // }

        // 5-7
        // if(args.length!=1) {
        // System.out.println("USAGE: java Exercise5_7 3120");
        // System.exit(0);
        // }

        // int money = 3510;

        // System.out.println(money);

        // int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
        // int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수

        // for(int i = 0; i < coinUnit.length; i++)
        // {
        //     while(money / coinUnit[i] > 0 && coin[i] > 0)
        //     {

        //         coin[i]--;
        //         money -= coinUnit[i];
                
        //     }
        //     System.out.println(coinUnit[i] + " : " + coin[i]);
            
        // }
        // if(money > 0) System.out.println("거스름돈 부족");


        // 5-8
        // int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
        // int[] counter = new int[4];

        // for(int ele : answer)
        // {
        //     counter[ele - 1]++;

        // }

        // for(int ele : counter)
        // {
            
        //     System.out.print(ele);
        //     while (ele > 0) {
        //         System.out.print('*');
        //         ele--;
        //     }
        //     System.out.println();

        // }



    } // end of main
    
}
