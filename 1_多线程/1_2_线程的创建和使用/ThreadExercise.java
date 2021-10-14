
/**
 * 线程练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 */
public class ThreadExercise {
    public static void main(String[] args) {
        ThreadExercise threadExercise = new ThreadExercise();
        threadExercise.new ThreadFindEven().start();
        threadExercise.new ThreadFindOdd().start();
    }
    class ThreadFindEven extends Thread{
        @Override
        public void run() {
           for(int i = 0; i < 100; i++){
               if(i%2 == 0) System.out.println("ThreadFindEven: " + i); 
           }
        }
    }
    class ThreadFindOdd extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                if(i%2 != 0) System.out.println("ThreadFindOdd: " + i); 
            }
        }
        
    }
}
