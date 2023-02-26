package jungsuk.thread;

public class ThreadEx_2 {

    static long startTime = 0;

    public static void main(String[] args) {

        /**
         *  main Thread : 메인 메서드의 코드를 수행하는 쓰레드
         *  - 메인 쓰레드이다.
         *  쓰레드의 종류 : 사용자 쓰레드, 데몬 쓰레드
         *  - 데몬 쓰레드는 사용자가 하는 작업을 도와준다.
         *
         *  - 프로그램은 사용자 쓰레드가 하나도 없을 때 종료된다.
         *   즉, 데몬 쓰레드만 남으면 종료된다.
         *
         * - OS는 매번 적절하게 스케줄링을 하기 때문에 프로그래머가 제어할 수 없다.
         * - 멀티쓰레드가 싱글쓰레드보다 수행시간이 더 오래걸린다
         * -> 쓰레드간 전환이 이루어질 때 context switching이 발생하고 시간이 걸리기 때문이다.
         */
        ThreadEx2_1 th1 = new ThreadEx2_1();
        ThreadEx2_2 th2 = new ThreadEx2_2();

        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            // 메인 메서드는 원래 쓰레드 호출 후 자기 자신의 일을 하고 종료된다.
            th1.join(); // main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); // main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 쓰레드들의 작업이 끝나고 소요 시간이 출력된다.
        System.out.println("Duration of Time : " + (System.currentTimeMillis() - startTime));

    }
}

class ThreadEx2_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 500; i ++) {
            System.out.print("-");
        }
    }
}

class ThreadEx2_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 500; i ++) {
            System.out.print("|");
        }
    }
}