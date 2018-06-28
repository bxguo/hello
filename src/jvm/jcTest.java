package jvm;

import java.util.concurrent.Semaphore;

/**
 * Created by bxguo on 2018/5/2 20:28
 */
public class jcTest{

    private static jcTest test = null;
    public static void main(String[] args) throws InterruptedException {
       // Semaphore semaphore = new Semaphore();
        System.out.println(1);
        test = new jcTest();
        System.out.println(2);
        testGc();
        testGc();
    }
    private static void testGc() throws InterruptedException {
        System.out.println(3);
        test = null;
        System.out.println(4);
        System.gc();
        System.out.println(5);
        Thread.sleep(1000);
        System.out.println(6);
        if (test == null) {
            System.out.println("我挂了");
        }else {
            System.out.println("我还活着");
        }
    }
    @Override
    public void finalize() throws Throwable {
        test = this;
        System.out.println("我被调用了");
    }
}
