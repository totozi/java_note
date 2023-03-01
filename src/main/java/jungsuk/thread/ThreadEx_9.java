package jungsuk.thread;

public class ThreadEx_9 {
    /**
     * join()
     * - 지정된 시간동안 특정 쓰레드가 작업하는 것을 기다린다.
     *
     * yield()
     * - 남은 시간을 다음 쓰레드에게 양보하고 자신은 실행대기한다.
     * - interrupt()와 적절히 섞어쓰면 응답성과 효율성을 높일 수 있다.
     * -> busy-waiting하는 시간을 다른 쓰레드에게 양보 가능
     * - OS 스케줄러에게 통보하는 것 뿐, 반드시 동작한다는 보장은 없다.
     */
    static long startTime = 0L;

    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        ThreadEx9_2 th2 = new ThreadEx9_2();

        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join(); // main 쓰레드가 th1의 작업이 끝날 때 까지 기다린다.
            th2.join(); // main 쓰레드가 th2의 작업이 끝날 때 까지 기다린다.

        } catch (InterruptedException e) {

        }

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));

    }
}


class ThreadEx9_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx9_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}

class MyThread2 implements Runnable {
    volatile boolean suspended  = false;
    volatile boolean stopped    = false;
    // volatile : 이 변수가 쉽게 바뀐다는 뜻
    // cpu의 코어들 내부의 캐시 메모리가 있다.
    // RAM의 변수들을 복사해서 가지고 있는데..
    // 캐시 메모리의 복사본을 사용 못하게 한다. 즉 매번 원본을 읽어오게 한다.

    Thread th;

    MyThread2(String name) {
        th = new Thread(this, name); // Thread(Runnable r, String name)
    }

    void start() {
        th.start();
    }

    void stop() {
        this.stopped = true;
        th.interrupt(); // 자고 있는 거 바로 깨우기
    }

    void suspend() {
        this.suspended = true;
        th.interrupt(); // 자고 있는 거(sleep 상태) 바로 깨우기
    }

    void resume() {
        this.suspended = false;
    }

    public void run() {
        while(!stopped) {

            if(!suspended) {

                System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){

                }

            } else {
                Thread.yield(); // 양보
            }

        } // while
    }
}
