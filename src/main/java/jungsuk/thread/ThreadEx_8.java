package jungsuk.thread;

public class ThreadEx_8 {
    /**
     * suspend() : 쓰레드 일시정지
     * resume()  :
     * stop()    : 완전히 정지
     * -> dead-lock 을 유발할 위험이 있어 deprecated
     * -> 직접 작성하여 쓰면 된다.
     */
    public static void main(String[] args) {
//        RunImplEx8_1 r = new RunImplEx8_1();
//        Thread th1 = new Thread(r,"*");
//        Thread th2 = new Thread(r,"**");
//        Thread th3 = new Thread(r,"***");

        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();

            Thread.sleep(2000);
            th2.suspend();

            Thread.sleep(3000);
            th1.resume();

            Thread.sleep(3000);
            th1.stop();
            th2.stop();

            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e){

        }
    }
}

class RunImplEx8_1 implements Runnable {
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }
    }
}

class MyThread implements Runnable {
    volatile boolean suspended  = false;
    volatile boolean stopped    = false;
    // volatile : 이 변수가 쉽게 바뀐다는 뜻
    // cpu의 코어들 내부의 캐시 메모리가 있다.
    // RAM의 변수들을 복사해서 가지고 있는데..
    // 캐시 메모리의 복사본을 사용 못하게 한다. 즉 매번 원본을 읽어오게 한다.

    Thread th;

    MyThread(String name) {
        th = new Thread(this, name); // Thread(Runnable r, String name)
    }

    void start() {
        th.start();
    }

    void stop() {
        this.stopped = true;
    }

    void suspend() {
        this.suspended = true;
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

            } // if

        } // while
    }
}
