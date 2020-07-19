package demo.thread;

import com.utils.TimeUtil;

public class ThreadTest extends Thread {

    private final Object sigLock = new Object();

    public void releaseSigLock() {

        System.out.println("我想要释放sigLock begin" + TimeUtil.getTimeNow());
        synchronized (sigLock) {
            System.out.println("我要释放sigLock begin" + TimeUtil.getTimeNow());
            sigLock.notifyAll();
            System.out.println("我要释放sigLock done" + TimeUtil.getTimeNow());
        }
    }

    public void run() {

        System.out.println("begin");
        try {
            System.out.println(TimeUtil.getTimeNow());
            synchronized (sigLock) {
                sigLock.wait(5000L);
            }
            System.out.println(TimeUtil.getTimeNow());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadTest.releaseSigLock();
    }

}
