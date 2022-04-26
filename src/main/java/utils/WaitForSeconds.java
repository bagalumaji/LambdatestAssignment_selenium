package utils;

import com.google.common.util.concurrent.Uninterruptibles;

import java.time.Duration;

public final class WaitForSeconds {
    private WaitForSeconds(){}

    public static void waitForTwoSeconds(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
    }

    public static void waitForSecond(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
    }
}
