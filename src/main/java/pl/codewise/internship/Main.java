package pl.codewise.internship;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jan on 2017-05-24.
 */
public class Main {
    public static void main(String [] args) throws Exception {
       Callable x = () -> {System.out.println("HEY!"); return "HEY";};
       Callable y = () -> {System.out.println("EJ!"); return "NEJ";};
       Scheduler a = new SchedulerIml();
        a.submit(10, x);
        a.submit(5,y);


    }
}
