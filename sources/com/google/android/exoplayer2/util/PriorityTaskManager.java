package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority = Integer.MIN_VALUE;
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i11, int i12) {
            super("Priority too low [priority=" + i11 + ", highest=" + i12 + "]");
        }
    }

    public void add(int i11) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i11));
            this.highestPriority = Math.max(this.highestPriority, i11);
        }
    }

    public void proceed(int i11) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i11) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i11) {
        boolean z11;
        synchronized (this.lock) {
            if (this.highestPriority == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public void proceedOrThrow(int i11) throws PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != i11) {
                throw new PriorityTooLowException(i11, this.highestPriority);
            }
        }
    }

    public void remove(int i11) {
        int i12;
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i11));
            if (this.queue.isEmpty()) {
                i12 = Integer.MIN_VALUE;
            } else {
                i12 = ((Integer) Util.castNonNull(this.queue.peek())).intValue();
            }
            this.highestPriority = i12;
            this.lock.notifyAll();
        }
    }
}
