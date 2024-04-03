package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import i2.d;
import i2.e;
import i2.f;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    @RequiresApi(16)
    public static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        @DoNotInline
        public static void postFrameCallback(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new a(runnable));
        }
    }

    @RequiresApi(28)
    public static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class Result {
    }

    /* access modifiers changed from: private */
    public static void writeInBackground(@NonNull Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new f(context));
    }

    @RequiresApi(16)
    public void d(@NonNull Context context) {
        Choreographer16Impl.postFrameCallback(new e(this, context));
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    /* renamed from: e */
    public void lambda$delayAfterFirstFrame$0(@NonNull Context context) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler28Impl.createAsync(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new d(context), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
    }

    @NonNull
    public Result create(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        d(context.getApplicationContext());
        return new Result();
    }
}
