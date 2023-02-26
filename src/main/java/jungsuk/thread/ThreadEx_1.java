package jungsuk.thread;

import javax.print.attribute.standard.RequestingUserName;
import java.util.stream.IntStream;

public class ThreadEx_1 {
    /**
     *  프로세스 : 실행 중인 프로그램. resource와 thread로 구성
     *  쓰레드  : 프로세스 내에서 실제 작업을 수행
     *           모든 프로세스는 하나 이상의 쓰레드를 가지고 있다.
     *  즉, 프로레스 : 쓰레드 = 공장 : 일꾼
     *  - 싱글 쓰레드 프로세스 : 자원 + 쓰레드
     *  - 멀티 쓰레드 프로세스 : 자원 + 쓰레드 + 쓰레드....
     *
     *
     *  하나의 새로운 프로세스를 생성하는 것보다
     *  하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다
     *
     *  CGI 방식 : 사용자가 웹사이트를 접근할 때마다 프로세스가 생성(멀티쓰레드 지원 x)
     *  Java Servlet : 멀티쓰레드를 지원 새로운 요청에 쓰레드 추가 -> 효율적
     *
     *  멀티 쓰레드의 장단점
     *  - 장점
     *  1. 시스템 자원을 보다 효율적으로 사용
     *  2. 사용자에 대한 응답성(responseness) 향상
     *  3. 작업이 분리되어 코드가 간결
     *  ex) 파일을 보내면서도 채팅을 할 수 있는 채팅 프로그램
     *  - 단점
     *  1. 동기화(synchroziation)에 주의
     *  2. 교착상태(dead-lock) 발생 주의
     *  3. 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야 한다.
     */
    public static void main(String[] args) {
        /**
         * 쓰레드의 구현과 실행
         * 1. Thread 클래스 상속 : 자바는 단일 상속이라 2번이 좋다
         * 2. Runnable 인터페이스 구현
         *
         * 쓰레드의 실행 - start()
         * - 쓰레드를 생성한 후에 start()를 호출해야 쓰레드가 작업을 시작한다.
         * -> OS 스케줄러가 실행순서 결정.. start()를 먼저 호출했다고 먼저 실행되는 것은 아님..
         * - JVM이 OS에 종속적인 요소 중 하나가 쓰레드
         *
         * start()와 run()
         * - run()을 작성했는데 왜 start()를 호출?
         *  : start 메서드가 새로운 호출 스택을 생성
         *    -> 새로운 호출 스택에 run메서드를 호출한다.
         *    -> start메서드는 종료
         *    -> 기존 스택, 새로운 스택이 서로 독립적인 작업 수행 가능..
         */

        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2  = new Thread(r);

        t1.start();
        t2.start();
        // 번갈아가며 실행됨..

    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 500; i ++) {
            System.out.print(0);
        }
    }
}

class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 500; i ++) {
            System.out.print(1);
        }
    }

}