package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable<Scheduler>() {
        public Scheduler call() throws Exception {
            return MainHolder.f14495a;
        }
    });

    public static final class MainHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f14495a = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper looper) {
        return from(looper, false);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler from(Looper looper, boolean z11) {
        if (looper != null) {
            return new HandlerScheduler(new Handler(looper), z11);
        }
        throw new NullPointerException("looper == null");
    }
}
