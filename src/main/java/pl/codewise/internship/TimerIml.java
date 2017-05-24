package pl.codewise.internship;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/**
 * Created by Jan on 2017-05-24.
 */
public class TimerIml<V> implements TimerID ,Runnable{
    private long nt;
    private long period;
    private volatile boolean toDelete = false;
    private Callable<V> task;
    private  V result = null;

    public TimerIml(Callable<V> task, long period){
        this. task = (task);
        this.nt = now();
        this.period = TimeUnit.SECONDS.toNanos(period);
    }

    private  long now() {
        return System.nanoTime();
    }
    @Override
    public void run(){
        while(!toDelete) {
            if ((now() - this.nt) > period) {
                try {
                    synchronized (this) {
                        result = task.call();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized boolean cancel(){
        if(result == null){
            this.toDelete = true;
        }
        return toDelete;

    }


    public boolean isToDelete() {
        return toDelete;
    }

    public V getResult() {
        while (!toDelete) {
            if (result != null)
                return result;
        }
        return null;
    }
}
