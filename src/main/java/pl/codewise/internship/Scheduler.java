
package pl.codewise.internship;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public interface Scheduler {
    TimerID submit(int expireTime, Callable task);

    boolean  stop (TimerID id);

}



