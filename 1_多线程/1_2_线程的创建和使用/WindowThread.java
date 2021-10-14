import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

/**
 * 使用多线程，实现三个窗口同时卖100张火车票，使用方式一，存在同步问题
 * 需要实例化三个Thread对象
 */
public class WindowThread {

    class Ticketer extends Thread{
        static int tickets = 100;
        @Override
        public void run() {
            while(tickets > 0){
                System.out.println(getName()+":"+ (--tickets));
            }
        }
    }

    public static void main(String[] args) {
        WindowThread windowThread =  new WindowThread();
        Ticketer ticker1 = windowThread.new Ticketer();
        Ticketer ticker2 = windowThread.new Ticketer();
        Ticketer ticker3 = windowThread.new Ticketer();

        ticker1.start();
        ticker2.start();
        ticker3.start();

    }
    
}

