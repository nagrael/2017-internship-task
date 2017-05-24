package pl.codewise.internship;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;

public class InternshipTaskTest {

    @Test
    public void shouldWork() {
        Scheduler schedul = new SchedulerIml();
        Callable<String> call_my_maybe = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
            return "Donne";
        };
        TimerID time = schedul.submit(5, call_my_maybe);
        Assert.assertEquals(time.getResult(), "Donne");
    }
    @Test
    public void cancelTest() throws InterruptedException {
        Scheduler schedul = new SchedulerIml();
        Callable<String> call_my_maybe = () -> "Donne";
        TimerID time = schedul.submit(5, call_my_maybe);
        time.cancel();
        Assert.assertEquals(time.getResult(), null);
        Thread.sleep(6000);
        Assert.assertEquals(time.getResult(), null);
    }
}
