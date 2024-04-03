package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public TimedSemaphore(long j11, TimeUnit timeUnit, int i11) {
        this((ScheduledExecutorService) null, j11, timeUnit, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void acquire() throws java.lang.InterruptedException {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.isShutdown()     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0033
            java.util.concurrent.ScheduledFuture<?> r0 = r3.task     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0011
            java.util.concurrent.ScheduledFuture r0 = r3.startTimer()     // Catch:{ all -> 0x003b }
            r3.task = r0     // Catch:{ all -> 0x003b }
        L_0x0011:
            int r0 = r3.getLimit()     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 <= 0) goto L_0x0023
            int r0 = r3.acquireCount     // Catch:{ all -> 0x003b }
            int r2 = r3.getLimit()     // Catch:{ all -> 0x003b }
            if (r0 >= r2) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0 = 0
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 != 0) goto L_0x002a
            r3.wait()     // Catch:{ all -> 0x003b }
            goto L_0x002f
        L_0x002a:
            int r2 = r3.acquireCount     // Catch:{ all -> 0x003b }
            int r2 = r2 + r1
            r3.acquireCount = r2     // Catch:{ all -> 0x003b }
        L_0x002f:
            if (r0 == 0) goto L_0x0011
            monitor-exit(r3)
            return
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003b }
            java.lang.String r1 = "TimedSemaphore is shut down!"
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.concurrent.TimedSemaphore.acquire():void");
    }

    public synchronized void endOfPeriod() {
        int i11 = this.acquireCount;
        this.lastCallsPerPeriod = i11;
        this.totalAcquireCount += (long) i11;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        double d11;
        long j11 = this.periodCount;
        if (j11 == 0) {
            d11 = 0.0d;
        } else {
            d11 = ((double) this.totalAcquireCount) / ((double) j11);
        }
        return d11;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public final synchronized void setLimit(int i11) {
        this.limit = i11;
    }

    public synchronized void shutdown() {
        if (!this.shutdown) {
            if (this.ownExecutor) {
                getExecutorService().shutdownNow();
            }
            ScheduledFuture<?> scheduledFuture = this.task;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.shutdown = true;
        }
    }

    public ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() {
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j11, TimeUnit timeUnit, int i11) {
        if (j11 > 0) {
            this.period = j11;
            this.unit = timeUnit;
            if (scheduledExecutorService != null) {
                this.executorService = scheduledExecutorService;
                this.ownExecutor = false;
            } else {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
                scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
                this.executorService = scheduledThreadPoolExecutor;
                this.ownExecutor = true;
            }
            setLimit(i11);
            return;
        }
        throw new IllegalArgumentException("Time period must be greater 0!");
    }
}
