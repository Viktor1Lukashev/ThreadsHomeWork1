import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

public class Thread1RandArray implements Callable<ArrayList<Integer>> {
    private ArrayList<Integer> list;
    private final Random rand;

    public Thread1RandArray(ArrayList<Integer> _list) {
        list = _list;
        rand = new Random();
    }
    public ArrayList<Integer> get() {
        return list;
    }
    @Override
    public ArrayList<Integer> call() {
        synchronized(list) {
            for (int i = 0; i < 10; i++) {
                list.add(rand.nextInt(10));
            }
            list.notifyAll();
            return list;
        }

    }
}
