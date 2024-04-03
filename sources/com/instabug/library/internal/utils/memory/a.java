package com.instabug.library.internal.utils.memory;

import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.settings.SettingsManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f51119a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f51120b;

    private a() {
    }

    public static final boolean a() {
        return f51120b;
    }

    @JvmStatic
    public static final void b() {
        if (f51119a.c()) {
            IBGDiagnostics.reportNonFatal(new b("Device is running low on memory"), "Disabling Instabug temporaily", 1);
            Instabug.pauseSdk();
            f51120b = true;
        }
    }

    private final boolean c() {
        if (SettingsManager.getInstance().getFeatureState(Feature.DISABLE_ON_LOW_MEMORY, false) == Feature.State.ENABLED) {
            return true;
        }
        return false;
    }

    public static final void a(boolean z11) {
        f51120b = z11;
    }

    @JvmStatic
    public static final void a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "featuresResponse");
        SettingsManager.getInstance().setFeatureEnabled(Feature.DISABLE_ON_LOW_MEMORY.name(), jSONObject.optBoolean("an_disable_on_low_memory", false));
    }
}
