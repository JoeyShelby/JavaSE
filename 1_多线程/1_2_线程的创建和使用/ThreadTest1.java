/**
 * 方式一：继承于Thread类
 */

 //1. 创建一个继承于Thread类的子类
public class ThreadTest1 extends Thread{
    public static void main(String[] args) {
        // 3. 创建Thread类的子类对象
        // 4. 通过子对象调用start()
        //new ThreadTest().run(); <---常见错误，这样做只是普通地调用了run()方法，没有启动线程
        new ThreadTest1().start();
        for(int i = 0; i < 8; i++){
            System.out.println("maim:"+i);
        }
    }
    //2. 重写Thread类的run()方法
    @Override
    public void run() {
        for(int i = 0; i < 8; i++){
            System.out.println("Thread: Hello World!");
        }
        super.run();
    }
}