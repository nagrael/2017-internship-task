package pl.codewise.internship;

import com.google.common.collect.Sets;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Jan on 2017-05-24.
 */
public class SchedulerIml implements Scheduler{
    private Set<TimerIml> list = Sets.newConcurrentHashSet();

    @Override
    public TimerID submit(int expireTime, Callable task) {
        TimerIml iml = new TimerIml(task, expireTime);
        new Thread(iml).start();
        list.add(iml);
        return iml;
    }



    @Override
    public boolean stop(TimerID id) {
        if(id.cancel()){
            list.remove(id);
            return true;
        }
        return false;


    }



}
