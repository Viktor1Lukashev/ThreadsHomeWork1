import java.util.ArrayList;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Thread1RandArray tr = new Thread1RandArray(list);
        Thread2Sum tr2 = new Thread2Sum(list);
        Thread3Multy tr3 = new Thread3Multy(list);
        FutureTask<ArrayList<Integer>> task1 = new FutureTask<ArrayList<Integer>>(tr);
        FutureTask<Integer> task2 = new FutureTask<Integer>(tr2);
        FutureTask<Integer> task3 = new FutureTask<Integer>(tr3);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t1.join();
        t2.start();
        t3.start();
        System.out.println("результат первого потока: ");
        for (Integer i: task1.get()){
            System.out.print(i+ " ");

        }
        System.out.println();
        System.out.println("результат второго потока " + task2.get());
        System.out.println("результат третьего потока " + task3.get());
    }
}
