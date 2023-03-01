package jungsuk.thread;

import java.util.ArrayList;

public class ThreadEx_11 {
    /**
     * - 동기화의 효율을 높이기 위해 wait(), notify() 사용
     * - Object 클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
     *
     * - wait() - 객체의 lock을 풀고 쓰레드를 해당 객체의 waiting pool에 넣는다.
     * - notify() - waiting pool에서 대기중인 쓰레드 중 하나를 깨운다.
     * - notifyAll() - waiting pool에서 대기중인 모든 쓰레드를 깨운다.
     *
     */

    /**
     * 예제
     * 1. 요리사는 Table에 음식을 추가. 손님은 Table의 음식을 소비
     * 2. 요리사와 손님이 같은 객체(Table)을 공유하므로 동기화가 필요
     *
     * 예외 1. 요리사가 Table에 요리를 추가하는 과정에 손님이 요리를 먹음.
     * 예외 2. 하나 남은 요리를 손님2가 먹으려하는데 손님1이 먹음.
     * 
     * wait()으로 음식이 없을 때 손님이 lock을 풀고 기다리게 하자.
     * 요리사가 음식을 추가하면 notify로 손님에게 알리자
     * 
     * 단점 : wait()과 notify()가 누구를 깨울지 불분명 -> lock&condition으로 해결
     *
     */
    public static void main(String[] args) throws Exception {
        Table table = new Table(); // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"),  "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }



}


class Customer implements Runnable {
    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);


        } // while
    }


}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {
        this.table = table;
    }

    public void run() {
        while(true) {
            int idx = (int) (Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {

            }
        } // while
    }
}

class Table {
    String[] dishNames = {"donut", "donut", "burger" };
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait(); // COOK 쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
            }
        }
        dishes.add(dish);
        notify(); // 기다리고 있는 CUST 꺠우기 위함
        System.out.println("Dishes : " + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while(dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    wait(); // 음식이 없을 때 lock 반납 후 대기
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }

            } // while

            while(true) {
                for(int i = 0; i < dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i); // 음식소비
                        notify(); // 잠자고 있는 COOK을 깨우기 위함
                        return;
                    }
                } // for
                
                try {
                    System.out.println(name + " is waiting. ");
                    wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    
                }
            } // while

        } // synchronized
        
    }

    public int dishNum() {
        return dishNames.length;
    }

}