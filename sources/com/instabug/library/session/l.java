package com.instabug.library.session;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.internal.utils.PreferencesUtils;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class l {
    static {
        new l();
    }

    private l() {
    }

    @JvmStatic
    @NotNull
    @NonNull
    public static final PreferencesUtils a(@NotNull @NonNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PreferencesUtils(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
    }

    @JvmStatic
    @NotNull
    @NonNull
    public static final h b() {
        return new h();
    }

    @JvmStatic
    @Nullable
    public static final Void a(@NotNull @NonNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        PoolProvider.getNetworkingSingleThreadExecutor(IBGNetworkWorker.CORE).execute(runnable);
        return null;
    }

    @JvmStatic
    @NotNull
    public static final c a() {
        return e.f51745a;
    }
}
