/**
 * 创建三个线程，模拟三个窗口同时售票（共100张），使用方式二，存在同步问题
 * 实例化一个Runnable实现类对象和三个Thread对象
 */
public class WindowRunnable {

     class Ticketer implements Runnable{
        private int tickets = 100;
        @Override
        public void run() {
            while(tickets > 0){
                System.out.println(Thread.currentThread().getName()+" :" + (--tickets));
            }
        }
    }

    public static void main(String[] args) {
        WindowRunnable windowRunnable = new WindowRunnable();
        Ticketer ticketer = windowRunnable.new Ticketer();

        Thread thread1 = new Thread(ticketer);
        Thread thread2 = new Thread(ticketer);
        Thread thread3 = new Thread(ticketer);

        thread1.setName("window1");
        thread2.setName("window2");
        thread3.setName("window3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
