package jungsuk.thread;

public class ThreadEx_10 {
    /**
     * 쓰레드의 동기화(synchronization)
     * - 멀티 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 미칠 수 있다.
     * - 진행중인 작업이 다른 쓰레드에게 간섭받지 않게 하려면 동기화가 필요하다.
     * -> 동기화 : 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 막는 것
     * - 동기화하려면 간섭받지 않아야 하는 문장들을 '임계 영역'으로 설정
     * - 임계영역은 lock을 얻은 단 하나의 쓰레드만 출입가능(객체 1개에 lock 1개)
     *
     * synchronized를 이용한 동기화
     * - 임계영역(lock이 걸리는 영역)을 설정하는 방법
     * 1. 메서드 전체를 임계 영여으로 지정
     * 2. 특정한 영역을 임계 영역으로 지정
     * - 멤버 변수를 private으로 해야 동기화가 의미가 있다.
     */
    public static void main(String[] args) {
        Runnable r = new RunnableEx10();
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) { // synchronized로 임계영역 설정 1개의 쓰레드만 사용가능
        if(balance >= money) {
            try {
                Thread.sleep(1000);
                balance -= money;
            } catch (InterruptedException e) {

            }
        }
    } // withdraw
}

class RunnableEx10 implements Runnable {
    Account account = new Account();

    @Override
    public void run() {
        while(account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance : " + account.getBalance());
        }
    }
}
