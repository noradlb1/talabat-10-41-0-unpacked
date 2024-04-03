package t2;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowInfoTrackerDecorator;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class e {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "getOrCreate")
    public static WindowInfoTracker a(@NotNull Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void b(@NotNull WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void c() {
        WindowInfoTracker.Companion.reset();
    }
}
