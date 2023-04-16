package jungsuk.stream;

import java.util.*;
import java.util.stream.IntStream;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);

        int[][] arrSum = new int[list.size()/2][2];

        boolean timeLimit = false;

        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 2000)
        {
            Collections.shuffle(list);


            Set setSum = new HashSet();

            int j = 0;
            int sum = 0;
            for(int i = 0; i < list.size(); i++)
            {
                sum += list.get(i);
                if(i%2 == 1)
                {
                    setSum.add(sum);
                    arrSum[j][0] = sum;
                    arrSum[j][1] = list.get(i - 1) * list.get(i);
                    sum = 0;
                    j++;
                }
            }
            if(setSum.size() == 1)
            {
                timeLimit = true;
                break;
            }

        }

        if(!timeLimit)
        {
            System.out.println(-1);
        }
        int result = 0;
        for (int i = 0; i < arrSum.length; i++)
        {
            result += arrSum[i][1];
        }
        System.out.println(result);

    }

}
