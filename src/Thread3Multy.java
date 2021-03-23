import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Thread3Multy implements Callable<Integer> {
  private ArrayList<Integer> list;
    private int count;
    public  Thread3Multy(ArrayList<Integer>_list){
        list = _list;
        count = 0;
    }
    public Integer get() {
        return count;
    }
    @Override
    public Integer call(){
        synchronized (list){

                multy();
                return count;
            }

        }

    private void multy() {
        for(Integer i:list){
            count+=i;
        }
        count /= list.size();
    }
}