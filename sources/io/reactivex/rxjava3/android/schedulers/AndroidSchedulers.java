package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import i00.a;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;

public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new a());

    public static final class MainHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f18761a = AndroidSchedulers.internalFrom(Looper.getMainLooper(), true);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper looper) {
        return from(looper, true);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static Scheduler internalFrom(Looper looper, boolean z11) {
        return new HandlerScheduler(new Handler(looper), z11);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    public static Scheduler from(Looper looper, boolean z11) {
        if (looper != null) {
            return internalFrom(looper, z11);
        }
        throw new NullPointerException("looper == null");
    }
}
