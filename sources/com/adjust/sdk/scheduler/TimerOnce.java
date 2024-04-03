package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.Util;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerOnce {
    /* access modifiers changed from: private */
    public Runnable command;
    /* access modifiers changed from: private */
    public ILogger logger = AdjustFactory.getLogger();
    /* access modifiers changed from: private */

    /* renamed from: name  reason: collision with root package name */
    public String f40025name;
    private FutureScheduler scheduler;
    /* access modifiers changed from: private */
    public ScheduledFuture waitingTask;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            TimerOnce.this.logger.verbose("%s fired", TimerOnce.this.f40025name);
            TimerOnce.this.command.run();
            ScheduledFuture unused = TimerOnce.this.waitingTask = null;
        }
    }

    public TimerOnce(Runnable runnable, String str) {
        this.f40025name = str;
        this.scheduler = new SingleThreadFutureScheduler(str, true);
        this.command = runnable;
    }

    private void cancel(boolean z11) {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z11);
        }
        this.waitingTask = null;
        this.logger.verbose("%s canceled", this.f40025name);
    }

    public void cancel() {
        cancel(false);
    }

    public long getFireIn() {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture == null) {
            return 0;
        }
        return scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
    }

    public void startIn(long j11) {
        cancel(false);
        String format = Util.SecondsDisplayFormat.format(((double) j11) / 1000.0d);
        this.logger.verbose("%s starting. Launching in %s seconds", this.f40025name, format);
        this.waitingTask = this.scheduler.scheduleFuture(new a(), j11);
    }

    public void teardown() {
        cancel(true);
        FutureScheduler futureScheduler = this.scheduler;
        if (futureScheduler != null) {
            futureScheduler.teardown();
        }
        this.scheduler = null;
    }
}
