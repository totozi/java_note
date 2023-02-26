package jungsuk.thread;

import javax.swing.*;
import java.lang.annotation.Target;

public class ThreadEx_3 {
    /**
     * 쓰레드의 I/O blocking
     * - 입출력 시 작업이 중단되는 것을 blocking 이라고 한다.
     * - 사용자로부터 입력을 기다리는 구간에서 정지 -> 멀티 쓰레드로 해결
     *
     */
    // 싱글 쓰레드
    public static void main2(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은  " + input + "입니다.");

        for(int i = 10; i > 0; i-- ) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 멀티 쓰레드
    public static void main(String[] args) {
        ThreadEx3_1 th1 = new ThreadEx3_1();

        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은  " + input + "입니다.");
    }

}

class ThreadEx3_1 extends Thread {
    public void run() {
        for(int i = 10; i > 0; i-- ) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
