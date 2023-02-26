package jungsuk.thread;

import javax.swing.*;

public class ThreadEx_7 {
    /**
     * interrupt()
     * - 대기상태(WAITING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만든다.
     * - interrupt() - interrupted상태를 flase -> true로 변경
     * - isInterrupted() - 쓰레드의 interrupted 상태반환
     * - interrupted() - 현재 쓰레드의 interrupted 상태를 알려주고. false로 초기화
     *
     * - 조건문에 isInterrupted 로 분기처리하고 메인 쓰레드가 되는 곳에서 interrupt()를 호출해서 쓰레드의 반복작업을 멈추게 할 수 있다.
     *
     *
     */
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        System.out.println("isInterrupted : " + th1.isInterrupted()); // false

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // interrupted 상태가 true 가 된다.
//        System.out.println("isInterrupted : " + th1.isInterrupted()); // true

//        System.out.println("interrupted : " + Thread.interrupted()); // static 메서드이기 떄문에 현재 쓰레드의 상태를 반환하고 변경한다.
        // 여기서는 main 쓰레드의 상태를 반환해서 false가 나오는 것.

    }
}

class ThreadEx7_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x = 0; x < 2500000000L;x++);
        }
        System.out.println("isInterrupted : " + this.isInterrupted()); // true
        System.out.println("isInterrupted : " + this.isInterrupted()); // true

        System.out.println("interrupted : " + Thread.interrupted()); // true 반환 후 상태변수 false로 초기화
        System.out.println("interrupted : " + Thread.interrupted()); // false 반환

        System.out.println("countdown is done.");
    }
}
