/**
 *一、基本方法
    1. start() 启动线程
    2. run() 线程所执行的动作
    3. getName() 返回线程名称
    4. setName() 设置线程名称
    5. currentThread() 返回正在执行的线程 
    6. yield() 线程让步
    7. join() 等待插入
    8. sleep(long millis) 阻塞线程 

 二、线程优先级
    1. getPriority();
    2. setPriority(int p);
 */
public class ThreadMethods {
    class Thread1 extends Thread{
        @Override
        // 2. run() 线程所执行的动作
        public void run() {
            for(int i = 0; i < 10; i++){
                // 3. getName() 返回线程名称
                // 5. currentThread() 返回正在执行的线程 
                //6. yield() 线程让步
                //Thread.yield();
                System.out.println(currentThread().getName()+":priority:"+currentThread().getPriority()+":"+i);
                // 8. sleep(long millis) 阻塞线程
                if(i == 5){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Thread2 extends Thread{
        @Override
        // 2. run() 线程所执行的动作
        public void run() {
            // setPriority(MIN_PRIORITY);
            for(int i = 0; i < 10; i++){
                // 3. getName() 返回线程名称
                // 5. currentThread() 返回正在执行的线程                   //1. getPriority();获取线程优先级
                System.out.println(currentThread().getName()+":priority:"+currentThread().getPriority()+":"+i);
            }
        }
    }
    public static void main(String[] args) {
        //2.setPriority(int p) 设置线程优先级
        // 为什么下面这条语句会把所有的线程Priority都设置成Max？
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
        System.out.println(Thread.currentThread());
        ThreadMethods  threadMethods = new ThreadMethods();
        Thread1 thread1 = threadMethods.new Thread1();
        Thread2 thread2 = threadMethods.new Thread2();
        //4. setName() 设置线程名称
        thread1.setName("thread1");
        thread2.setName("thread2");
        // 这样就正常？
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
        // 1. start() 启动线程
        thread1.start();
        thread2.start();

        for(int i = 0; i < 20; i++){
            System.out.println(Thread.currentThread().getName()+":priority:"+Thread.currentThread().getPriority()+":"+i);

            if(i == 5){
                // 7. join() 等待插入
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            } 
        }
    }
}
