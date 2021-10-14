/**
 * 创建线程方式二：实现runnable接口
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }    
    }
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
    }
}
