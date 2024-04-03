package io.flutter.embedding.android;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

public class WindowInfoRepositoryCallbackAdapterWrapper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final WindowInfoTrackerCallbackAdapter f14164a;

    public WindowInfoRepositoryCallbackAdapterWrapper(@NonNull WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f14164a = windowInfoTrackerCallbackAdapter;
    }

    public void addWindowLayoutInfoListener(@NonNull Activity activity, @NonNull Executor executor, @NonNull Consumer<WindowLayoutInfo> consumer) {
        this.f14164a.addWindowLayoutInfoListener(activity, executor, consumer);
    }

    public void removeWindowLayoutInfoListener(@NonNull Consumer<WindowLayoutInfo> consumer) {
        this.f14164a.removeWindowLayoutInfoListener(consumer);
    }
}
