package jungsuk.thread;

public class ThreadEx_6 {
    /**
     * sleep()
     * - 현재 쓰레드를 지정된 시간동안 멈추게 한다.
     * - static method -> 현재 쓰레드에 대해서만 동작(yield()와 마찬가지)
     * - 예외처리를 해야한다(InterruptedException이 발생하면 깨어남)
     * - interrupt되거나 시간이 지나면 꺠어난다.
     */

    public static void main(String[] args) {

        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        th1.start();
        th2.start();


        delay(2*1000);

        System.out.println("<<main 쓰레드 종료>>");

    }

    static void delay(long millis) {
        try {
            //th1.sleep(2000); // th1이 sleep하는 것이 아니라 메인 쓰레드가 sleep하는 것
            Thread.sleep(2000); // 이렇게 써야 오해가 없다.
        } catch (InterruptedException e) {

        }
    }
}

class ThreadEx6_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1종료>>");
    }
}

class ThreadEx6_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2종료>>");
    }
}