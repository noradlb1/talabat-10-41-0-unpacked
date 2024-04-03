package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final boolean async;
    private final Handler handler;

    public static final class HandlerWorker extends Scheduler.Worker {
        private final boolean async;
        private volatile boolean disposed;
        private final Handler handler;

        public HandlerWorker(Handler handler2, boolean z11) {
            this.handler = handler2;
            this.async = z11;
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        @SuppressLint({"NewApi"})
        public Disposable schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.disposed) {
                return a.a();
            } else {
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
                Message obtain = Message.obtain(this.handler, scheduledRunnable);
                obtain.obj = this;
                if (this.async) {
                    obtain.setAsynchronous(true);
                }
                this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
                if (!this.disposed) {
                    return scheduledRunnable;
                }
                this.handler.removeCallbacks(scheduledRunnable);
                return a.a();
            }
        }
    }

    public static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        public ScheduledRunnable(Handler handler2, Runnable runnable) {
            this.handler = handler2;
            this.delegate = runnable;
        }

        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th2) {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public HandlerScheduler(Handler handler2, boolean z11) {
        this.handler = handler2;
        this.async = z11;
    }

    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    @SuppressLint({"NewApi"})
    public Disposable scheduleDirect(Runnable runnable, long j11, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
            Message obtain = Message.obtain(this.handler, scheduledRunnable);
            if (this.async) {
                obtain.setAsynchronous(true);
            }
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
