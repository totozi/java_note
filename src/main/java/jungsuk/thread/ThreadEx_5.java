package jungsuk.thread;

public class ThreadEx_5 implements Runnable {
    /**
     * 쓰레드 그룹
     * - 서로 관련된 쓰레드를 그룹으로 묶어서 다루기 위한 것
     * - 모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
     * - 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 'main쓰레드 그룹'에 속한다.
     * - 자신을 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위를 상속받는다.
     *
     * 데몬 쓰레드(demon thread)
     * - 일반 쓰레드(non-demon thread)의 작업을 돕는 보조적인 역할을 수행
     * - 일반 쓰레드가 모두 종료되면 자동적으로 종료된다.
     * - 가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
     * - 무한루프와 조건문을 사용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
     * - setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실행되어야 한다.
     *   그렇지 않으면 IllegalThreadStateException이 발생한다.
     *
     *   쓰레드의 상태
     *   - NEW : 쓰레드가 생성되고 아직 start() 호출 전
     *   - RUNNABLE : 실행 중 또는 실행 가능한 상태
     *   - BLOCKED : 동기화블럭에 의해서 일시정지된 상태(lock이 풀릴 때까지 기다리는 상태)
     *   - WAITING, TIMED_WAITING : 쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시정지 상태, TIMED_는 일시정지시간이 정해진 것
     *   - TERMINATED : 쓰레드의 작업이 종료된 상태
     *
     *   - time-out // 시간종료
     *   - resume() // 재개
     *   - notify()
     *   - interrupt() // 꺠우기
     *
     */

    static boolean autoSave = false;
    public static void main(String[] args) { // 메인 쓰레드
        Thread t = new Thread(new ThreadEx_5());
        // Thread(Runnable r) 이 생성자를 호출할 때 Runnable 인터페이스를 구현한 객체를 넣어준다.

        t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. 이 쓰레드가 데몬쓰레드가 되도록한다.
        t.start();

        for(int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(i);
//            System.out.println(t.isDaemon());

            if(i == 5) autoSave = true;
        }
        System.out.println("프로그램 종료");
    }

    @Override
    public void run() { // 데몬 쓰레드
        while(true) {

           try {
               Thread.sleep(3*1000); // 3초마다
           } catch (InterruptedException e) {

           }

           // autoSave의 값이 true면 autoSave() 호출
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("the working file has been saved.");
    }
}

