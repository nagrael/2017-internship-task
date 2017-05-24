package pl.codewise.internship;

/**
 * Created by Jan on 2017-05-24.
 */
public interface TimerID<V> {
    boolean cancel();
    V getResult();
}
