import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Thread2Sum implements Callable<Integer> {
    private ArrayList<Integer> list;
    private int count;
    public Thread2Sum(ArrayList<Integer> _list){

        list = _list;
        count = 0;
    }
    public Integer get() {
        return count;
    }

    @Override
    public Integer call() throws InterruptedException {
        synchronized (list){

                for(Integer i:list){
                    count += i;
                }

                return count;
        }

    }
}
