package io.flutter.plugins.googlesignin;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class Executors {

    public static final class UiThreadExecutor implements Executor {
        private static final Handler UI_THREAD = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            UI_THREAD.post(runnable);
        }
    }

    private Executors() {
    }

    @NonNull
    public static Executor uiThreadExecutor() {
        return new UiThreadExecutor();
    }
}
