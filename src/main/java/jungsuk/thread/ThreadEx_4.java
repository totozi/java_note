package jungsuk.thread;

public class ThreadEx_4 {
    /**
     * 쓰레드의 우선순위
     * - 작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 갖게 할 수 있다.
     * - setPriority(int newPriority) 1 ~ 10 -> JVM에서 정해놓은것 실제 윈도우는 32단계
     * -> 희망사항을 담는 것. OS 스케줄러에게 요청하는 것이지 그대로 되는 것이 아니다.
     *
     *
     */
    public static void main(String[] args) {
        ThreadEx4_1 th1 = new ThreadEx4_1();
        ThreadEx4_2 th2 = new ThreadEx4_2();

        th2.setPriority(7);

        System.out.println(th1.getPriority());
        System.out.println(th2.getPriority());
        th1.start();
        th2.start();
    }
}

class ThreadEx4_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for(int x = 0; x < 1000000000; x++);
        }
    }
}

class ThreadEx4_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for(int x = 0; x < 1000000000; x++);
        }
    }
}
