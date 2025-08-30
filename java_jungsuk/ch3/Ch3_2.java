package java_jungsuk.ch3;

public class Ch3_2 {
    
    public static void main(String[] args) {
        
        int numOfApples = 123;
        int sizeOfBucket = 10;
        int numOfBuckets = numOfApples / sizeOfBucket
                + (numOfApples % sizeOfBucket > 0 ? 1 : 0);

        System.out.println(numOfBuckets);

    }
}
