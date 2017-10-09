package com.okio;

import java.util.concurrent.TimeUnit;

/**
 * Created by aliouswang on 17/10/9.
 */
public class Timeout {

    private long deadlineNanos;

    public Timeout() {

    }

    public Timeout start(long timeout, TimeUnit unit) {
        deadlineNanos = System.nanoTime() + unit.toNanos(timeout);
        return this;
    }

    public boolean reached() {
        return System. nanoTime() - deadlineNanos >= 0;
    }

}
